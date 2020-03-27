<#import "parts/common.ftlh" as common>

<@common.page>
    <h5>${username}</h5>
    ${message!}
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="password"> Password: </label>
            <div class="col-sm-6">
                <input class="form-control" id="password" type="password" name="password"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="email"> Email: </label>
            <div class="col-sm-6">
                <input class="form-control" id="email" type="email" name="email" value="${email!''}"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</@common.page>