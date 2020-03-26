<#import "parts/common.ftlh" as common>
<#import "parts/login.ftlh" as login>

<@common.page>
    <div class="mb-4">Add new user</div>
    ${message!}
    <@login.login "/registration" true />
</@common.page>