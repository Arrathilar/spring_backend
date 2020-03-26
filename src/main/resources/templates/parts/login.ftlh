<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="username"> User Name : </label>
            <div class="col-sm-6">
                <input class="form-control" id="username" type="text" name="username"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="password"> Password: </label>
            <div class="col-sm-6">
                <input class="form-control" id="password" type="password" name="password"/>
            </div>
        </div>
        <#if isRegisterForm>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="email"> Email: </label>
            <div class="col-sm-6">
                <input class="form-control" id="email" type="email" name="email"/>
            </div>
        </div>
        </#if>
            <button type="submit" class="btn btn-primary"><#if isRegisterForm>Create<#else>Sign in</#if></button>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <#if !isRegisterForm><a href="/registration">registration</a></#if>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-primary">Sign out</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</#macro>