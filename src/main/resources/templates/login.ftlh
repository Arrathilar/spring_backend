<#import "parts/common.ftlh" as common>
<#import "parts/login.ftlh" as login>

<@common.page>
    Login page
    <@login.login "/login" />
    <a href="/registration">registration</a>
</@common.page>