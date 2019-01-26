<html>
<#include "../common/header.ftl">
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <#if isOpen==true>
                        <li>
                            <a href="/nbiot/show?open=false">中止接受信息</a>
                        </li>
                        </#if>
                        <#if isOpen==false>
                        <li>
                            <a href="/nbiot/show?open=true">恢复接受信息</a>
                        </li>
                        </#if>
                        <li>
                            <a href="/nbiot/device?open=${isOpen?string("true","false")}">设备控制面板</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">One more separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" />
                        </div> <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Link</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">Action</a>
                                </li>
                                <li>
                                    <a href="#">Another action</a>
                                </li>
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>
                        设备ID
                    </th>
                    <th>
                        亮度
                    </th>
                    <th>
                        温度
                    </th>
                    <th>
                        电流
                    </th>
                    <th>
                        状态
                    </th>
                    <th>
                        消息接受时间
                    </th>
                </tr>
                </thead>
                <tbody>
                <#list beanList as bean>
                <tr>
                    <td>
                        ${bean.id}
                    </td>
                    <td>
                        ${bean.brightness}
                    </td>
                    <td>
                        ${bean.temperature}
                    </td>
                    <td>
                        ${bean.current}
                    </td>
                    <td>
                        ${bean.getDeviceEnum().status}
                    </td>
                    <td>
                        ${bean.time?string('yyyy-MM-dd HH:mm:ss')}
                    </td>
                </tr>
                </#list>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    function myrefresh()
    {
        window.location.reload();
    }
    setTimeout('myrefresh()',5000);
</script>
</html>