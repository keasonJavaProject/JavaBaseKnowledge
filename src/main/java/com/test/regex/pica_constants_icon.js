PICA_ADMIN_APP.controller('constantsIconController', function($rootScope, $scope,  $http, $modal,picaAlert,uiGridConstants) {
    var ipAddress = "http://" + window.location.host;
    localStorage.setItem("Url", ipAddress + "/PICA_ADMIN_BE/rest/");
    //获取功能权限1查看,2添加修改,3删除,4导入,5导出,6提交,7发布,8热度排序,9批量处理
    $scope.functionRoleArr = sessionStorage.getItem("function_role").split('');

    $scope.modal = {
//						title : 'Title',
        content : 'Hello Modal<br />This is a multiline message!',
        checked : false
    };
    $scope.totalItems = 0;
    $scope.pagingOptions = {
        paginationPageSizes : [10, 20, 50, 100, 200, 500, 700, 1000,
            1500, 2000 ],
        paginationCurrentPage : 1,
        paginationPageSize : 10
    };

    $scope.gridOptions = {
        rowHeight : 30,
        data : 'picapConstantsIconModels',
        enablePaging : true,
//							showFooter : true,
        paginationPageSizes : $scope.pagingOptions.paginationPageSizes,
        paginationPageSize: $scope.pagingOptions.paginationPageSize,
        totalItems : 'totalItems',
        options : $scope.pagingOptions,
        i18n : 'zh-cn',
        showColumnMenu : true,
        jqueryUIDraggable : true,
        showSelectionCheckbox : true,
        multiSelect : true,
        selectedItems : [],
        enableCellEdit: false,
        enableRowSelection : true,
        keepLastSelected : false,

        //设置排序属性
        enableSorting : true,
        // 设置菜单属性
        enableColumnMenus : true,
        // 设置右侧菜单属性
        enableGridMenu: true,
        //标题搜索框
        enableFiltering: true,
        enablePagination: true, //是否分页，默认为true
        enablePaginationControls: true, //使用默认的底部分页
        enableHorizontalScrollbar : 0,

        enableColumnResizing : true,
        columnDefs : [
            {
                field : 'id',
                displayName : 'ID',
                 //width : 120,
                cellTooltip: function( row ) {
                    return row.entity.id;
                },
                headerTooltip: 'ID'
            },
            {
                field : 'type_code',
                displayName : '类型编码',
               // width : 100,
                cellTooltip: function( row ) {
                    return row.entity.type_code;
                },
                headerTooltip: '类型编码'
            },
            {
                field : 'type_name',
                displayName : '类型名称',
               // width : 150,
                cellTooltip: function( row ) {
                    return row.entity.type_name;
                },
                headerTooltip: '类型名称'
            },
            {
                field : 'no',
                displayName : '编号',
                //width : 150,
                cellTooltip: function( row ) {
                    return row.entity.no;
                },
                headerTooltip: '编号'
                // cellFilter : 'moduleTypeFilter'
            },
            {
                field : 'value',
                displayName : '值',
               // width : 150,
                cellTooltip: function( row ) {
                    return row.entity.value;
                },
                headerTooltip: '值'
            },
            {
                field : 'icon_type',
                displayName : '图标类型',
                // width : 150,
                cellTooltip: function( row ) {
                    return row.entity.icon_type;
                },
                headerTooltip: '图标类型',
                cellFilter : 'iconTypeFilter',
                headerCellClass: 'grid_head_color',
                cellClass: 'grid_head_color',
                enableCellEdit: true,
                filter: {
                    type: uiGridConstants.filter.SELECT,
                    selectOptions: [
                        {value: 1, label: '选中'},
                        {value: 2, label: '未选中'}
                    ]
                },
                editableCellTemplate: 'ui-grid/dropdownEditor',
                editDropdownValueLabel: 'icon_type',
                editDropdownOptionsArray: [
                    {
                        id: 1,
                        icon_type: '选中'
                    }, {
                        id: 2,
                        icon_type: '未选中'
                    }
                ]
            },
            {
                field : 'status',
                displayName : '发布状态',
                // width : 150,
                cellTooltip: function( row ) {
                    return row.entity.status;
                },
                headerTooltip: '发布状态',
                cellFilter : 'iconStatusFilter',
                headerCellClass: 'grid_head_color',
                cellClass: 'grid_head_color',
                enableCellEdit: true,
                filter: {
                    type: uiGridConstants.filter.SELECT,
                    selectOptions: [
                        {value: 1, label: '未发布'},
                        {value: 2, label: '已发布'}
                    ]
                },
                editableCellTemplate: 'ui-grid/dropdownEditor',
                editDropdownValueLabel: 'status',
                editDropdownOptionsArray: [
                    {
                        id: 1,
                        status: '未发布'
                    }, {
                        id: 2,
                        status: '已发布'
                    }
                ]
            },
            {
                field : 'id',
                cellTemplate : '<div style="padding: 5px;">' +
                '<i ng-if="grid.appScope.functionRoleArr[5] == 1" ng-click="grid.appScope.periodChanage(row.entity)"  class="glyphicon glyphicon-ok list_icon"></i>' +
                '<i ng-if="grid.appScope.functionRoleArr[1] == 1" ng-click="grid.appScope.insertOrUpdateConstantsIcon(row.entity)" class="glyphicon glyphicon-pencil list_icon"></i>' +
                '<i ng-if="grid.appScope.functionRoleArr[2] == 1" ng-click="grid.appScope.deleteConstantsIcon(row.entity)" class="glyphicon glyphicon-trash list_icon"></i></div>',
                displayName : '操作',
                enableFiltering: false,
                width: 120,
                pinnedRight:true
            }
        ],
    };

    $rootScope.$on("pageChange", function(event, msg) {
        $scope.pagingOptions.paginationCurrentPage = msg.paginationCurrentPage;
        $scope.pagingOptions.paginationPageSize = msg.paginationPageSize;
        $scope.load();
    });

    // selectedItems选择用 start
    $scope.toggleMultiSelect = function() {
        $scope.gridApi.selection
            .setMultiSelect(!$scope.gridApi.grid.options.multiSelect);
    };

    $scope.toggleRow = function() {
        $scope.gridApi.selection
            .toggleRowSelection($scope.gridOptions.data[0]);
    };

    $scope.gridOptions.onRegisterApi = function(gridApi) {
        $scope.gridApi = gridApi;
    };

    $scope.searchParam = {};


    $scope.resetSearch= function () {
        $scope.searchParam ={};
    }

    $scope.getIconTypeList = function(){
        $http({
            method: 'POST',
            url: localStorage.getItem("Url") + "PICAConstantsServiceImpl/getIconTypeList"
        }).success(function(data){
            $scope.iconTypeList = data.iconTypeList;
        }).error(function(data){
            //console.error("getIconTypeList error:"+JSON.stringify(datas))
            $rootScope.errorResponseCheck(data);
        });
    }

    $scope.getIconNoList = function(){
        if(!$scope.searchParam.type_code) {
            $scope.iconNoList=[];
            return;
        }
        $http({
            method: 'POST',
            data:$scope.searchParam,
            url: localStorage.getItem("Url") + "PICAConstantsServiceImpl/getIconNoList"
        }).success(function(data){
            $scope.iconNoList = data.iconNoList;
        }).error(function(data){
            //console.error("getIconNoList error:"+JSON.stringify(data))
            $rootScope.errorResponseCheck(data);
        });
    }

    $scope.getIconTypeList();

    $rootScope.load = function () {
        picaAlert.openLoading();
        //初始化信息
        $scope.req={
            token: localStorage.getItem("token"),
            pageSize : $scope.pagingOptions.paginationPageSize,
            pageNo : $scope.pagingOptions.paginationCurrentPage,
            param: $scope.searchParam
        };
        $http({
            method: 'POST',
            url: localStorage.getItem("Url") + "PICAConstantsIconServiceImpl/selectByParam",
            data: JSON.stringify($scope.req)
        }).success(function(data){
            picaAlert.closeLoading();
            $scope.picapConstantsIconModels = data.picapConstantsIconModels;
            $scope.pagingOptions.paginationCurrentPage = data.pageNo;
            $scope.pagingOptions.totalItems = data.totalRows;
            $scope.totalItems = data.totalRows;

        }).error(function(data){
            //alert("error:" + data);
            picaAlert.closeLoading();
            $rootScope.errorResponseCheck(data);
        });
    }
    $scope.load();

    $scope.localIconTypeList =[
        {"no":1,"value":"选中"},
        {"no":2,"value":"未选中"}
    ];

    $scope.localIconStatusList =[
        {"no":1,"value":"未发布"},
        {"no":2,"value":"已发布"}
    ];

    $scope.insertOrUpdateConstantsIcon = function (constantsIcon) {
        $rootScope.localIconTypeList = $scope.localIconTypeList;
        $rootScope.localIconStatusList = $scope.localIconStatusList;
        $rootScope.getIconTypeList = $scope.getIconTypeList;
        $rootScope.getIconNoList = $scope.getIconNoList;
        $rootScope.constantsIcon = constantsIcon;

        var myOtherModal = $modal({
            template : "modals/modal_add_constants_icon.html",
            // persist: true,
            show : true,
            backdrop : 'static',
            scope : $scope,
            keyboard : false
        });
        myOtherModal.$promise.then(myOtherModal.show);
    };
     
    $scope.deleteConstantsIcon = function (data) {
        $scope.req={
            token: localStorage.getItem("token"),
            param: data
        };
        $rootScope.modalClick("提示", "确定要删除吗？", "是", function () {
            picaAlert.openLoading();
            $http({
                method: 'POST',
                url: localStorage.getItem("Url") + "PICAConstantsIconServiceImpl/LogicalDelete",
                data: JSON.stringify($scope.req)
            }).success(function(data){
                picaAlert.closeLoading();
                $rootScope.load();
            }).error(function(data){
                //console.log(JSON.stringify(data));
                picaAlert.closeLoading();
                $rootScope.errorResponseCheck(data);
            });
            $('#model-modify').modal('hide');
        },"否",null);
    }

    $scope.periodChanage = function (data) {
        var data = {
            token : localStorage.getItem("token"),
            param : data
        }
        $rootScope.modalClick("提示", "确定要保存修改吗？", "是", function () {
            picaAlert.openLoading();
            $http(
                {
                    method : 'POST',
                    url : localStorage.getItem("Url") + "PICAConstantsIconServiceImpl/insertConstantsIcon",
                    data : JSON.stringify(data)
                }).success(function(data) {
                picaAlert.closeLoading();
                $rootScope.load();
                hide();
            }).error(function(data) {
                picaAlert.closeLoading();
                //console.log(JSON.stringify(data));
                $rootScope.errorResponseCheck(data);
            });
            $('#model-modify').modal('hide');
        },"否",null);
    }
});

// 分配角色
PICA_ADMIN_APP.controller('addOrUpdateConstantsIcon', function($rootScope, $scope, $http, $modal, picaAlert) {
        $scope.localIconTypeList = $rootScope.localIconTypeList;
        $rootScope.localIconTypeList= null;
        $scope.localIconStatusList =$rootScope.localIconStatusList;
        $rootScope.localIconStatusList =null;
        $scope.getIconTypeList= $rootScope.getIconTypeList;
        $rootScope.getIconTypeList =null;
        $scope.constantsIcon = $rootScope.constantsIcon;

        $scope.saveConstantsIcon = function (hide) {
        picaAlert.openLoading();
        var data = {
            token : localStorage.getItem("token"),
            param : $scope.constantsIcon,
            fileJsonArr1: $scope.fileJson1,
        }
        $http(
            {
                method : 'POST',
                url : localStorage.getItem("Url") + "PICAConstantsIconServiceImpl/insertConstantsIcon",
                data : JSON.stringify(data)
            }).success(function(data) {
            picaAlert.closeLoading();
            $rootScope.load();
            hide();
        }).error(function(data) {
            picaAlert.closeLoading();
            //console.log(JSON.stringify(data));
            $rootScope.errorResponseCheck(data);
        });
    }

    $scope.imageUploadClick = function () {
        $("#imageUpload1").click();
        angular.element('#containerBody').html('')
    }

    //读取文件
    $scope.file_changed = function (element) {
        //图片
        $scope.fileJson1 = new Array();

        $scope.file_flag = false;
        var reader = new FileReader();
        var file = element.files[0];
        var ext = file.type;
        $scope.fileName = file.name;
        var arr = ext.split('/');
        $scope.filety = "." + arr[1];

        if (isEmptyUtils(ext)) {
            ext = $scope.fileName.substring($scope.fileName.lastIndexOf(".") + 1);
            $scope.filety = "." + ext;
        }

        reader.onload = function (e) {
            var fileJson = {
                fileName: $scope.fileName,
                file: e.target.result.substr(e.target.result.indexOf("base64,") + 7),
                ext: $scope.filety
            };

            var fileVar = {
                name: $scope.fileName,
                type: 'image',
                base64: fileJson
            };
            $scope.fileJson1.push(fileVar);
            $scope.pictureName = $scope.fileName;

            //显示图片内容
            var $img = $('<img>').attr("src", e.target.result);
            $('#preview').empty().append($img);
            $('#preview img').css('width', '100%');
        };
        reader.readAsDataURL(file);
    };

    $scope.getIconNoList = function(){
        if(!$scope.constantsIcon || !$scope.constantsIcon.type_code) {
            $scope.iconNoList=[];
            return;
        }
        $http({
            method: 'POST',
            data:$scope.constantsIcon,
            url: localStorage.getItem("Url") + "PICAConstantsServiceImpl/getIconNoList"
        }).success(function(data){
            $scope.iconNoList = data.iconNoList;
        }).error(function(data){
            //console.error("getIconNoList error:"+JSON.stringify(data))
            $rootScope.errorResponseCheck(data);
        });
    };
    $scope.getIconNoList();

    $scope.checkDisabled =function () {
        return (!$scope || !$scope.constantsIcon || !$scope.constantsIcon.type_code || !$scope.constantsIcon.no ||!$scope.constantsIcon.status ||!$scope.constantsIcon.icon_type);
    }
})


PICA_ADMIN_APP.filter('iconTypeFilter', function() {
    var genderHash = {
        1 : '选中',
        2 : '未选中'
    };
    return function(input) {
        if (!input) {
            return '';
        } else {
            return genderHash[input];
        }
    };
})
PICA_ADMIN_APP.filter('iconStatusFilter', function() {
    var genderHash = {
        1 : '未发布',
        2 : '已发布'
    };
    return function(input) {
        if (!input) {
            return '';
        } else {
            return genderHash[input];
        }
    };
})