<#import "parts/common.ftlh" as common>
<#import "parts/login.ftlh" as login>

<@common.page>
    Add new user
    ${message!}
    <@login.login "/registration" />
</@common.page>