package com.util.idGenerator;

import java.util.Date;
import java.util.Random;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/10/31 22:14
 */
public class IdServiceManager {
	public IdServiceManager() {
		this.workerId = (long)(new Random().nextInt(1022)+1);
	}

	/**
	 * 功能：生成ID(线程安全)
	 */
	public synchronized String genId() {
		long timestamp = timeGen();
		// 如果当前时间小于上一次ID生成的时间戳，说明系统时钟被修改过，回退在上一次ID生成时间之前应当抛出异常！！！
		validateTimestamp(timestamp, lastTimestamp);
		// 如果是同一时间生成的，则进行毫秒内sequence生成
		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & IdMeta.SEQUENCE_MASK;
			// 溢出处理
			if (sequence == 0) {// 阻塞到下一毫秒,获得新时间戳
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else { // 时间戳改变，毫秒内sequence重置
			sequence = 0L;
		}
		// 上次生成ID时间截
		lastTimestamp = timestamp;

		// 移位并通过或运算组成64位ID
		Long id = ((timestamp - IdMeta.START_TIME) << IdMeta.TIMESTAMP_LEFT_SHIFT_BITS)
				| (workerId << IdMeta.ID_SHIFT_BITS) | sequence;
		return String.valueOf(id);
	}

	/**
	 * 如果当前时间戳小于上一次ID生成的时间戳，说明系统时钟被修改过，回退在上一次ID生成时间之前应当抛出异常！！！
	 *
	 * @param lastTimestamp
	 *            上一次ID生成的时间戳
	 * @param timestamp
	 *            当前时间戳
	 */
	private void validateTimestamp(long timestamp, long lastTimestamp) {
		if (timestamp < lastTimestamp) {
			throw new IllegalStateException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}
	}

	/**
	 * 阻塞到下一毫秒,获得新时间戳
	 *
	 * @param lastTimestamp
	 *            上次生成ID时间截
	 * @return 当前时间戳
	 */
	private long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	/**
	 * 获取以毫秒为单位的当前时间
	 *
	 * @return 当前时间(毫秒)
	 */
	private long timeGen() {
		return System.currentTimeMillis();
	}


	/**
	 * 对时间戳单独进行解析
	 *
	 * @param time
	 *            时间戳
	 * @return 生成的Date时间
	 */
	public Date transTime(long time) {
		return new Date(time + IdMeta.START_TIME);
	}


	public long getLastTimestamp() {
		return lastTimestamp;
	}

	public void setLastTimestamp(long lastTimestamp) {
		this.lastTimestamp = lastTimestamp;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public long getWorkerId() {
		return workerId;
	}

	public IdMeta getIdMeta() {
		return idMeta;
	}

	public void setIdMeta(IdMeta idMeta) {
		this.idMeta = idMeta;
	}

	/**
	 * 上一毫秒数
	 */
	private Long lastTimestamp = -1L;

	/**
	 * 毫秒内Sequence(0~4095)
	 */
	private Long sequence = 0L;

	/**
	 * 机器ID(0-1023)
	 */
	private Long workerId;

	/**
	 * 各种元数据
	 */
	private IdMeta idMeta;
	
	public static void main(String[] args) {
		IdServiceManager idServiceManager = new IdServiceManager();
		System.out.println(idServiceManager.genId());

	}
}
