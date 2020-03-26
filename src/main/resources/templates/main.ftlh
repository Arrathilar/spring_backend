<#import "parts/common.ftlh" as common>
<#import "parts/login.ftlh" as login>

<@common.page>
    <@login.logout />
    <span><a href="/user">User list</a></span>
    <div>
        <form method="post" enctype="multipart/form-data">
            <label>
                <input type="text" name="title" placeholder="Введите заголовок">
            </label>
            <label>
                <input type="text" name="body" placeholder="Введите пост">
            </label>
            <label>
                <input type="text" name="tag" placeholder="Введите тег">
            </label>
            <label>
                <input type="file" name="file">
            </label>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Submit</button>
        </form>
    </div>
    <form method="get" action="/main">
        <label>
            <input type="text" name="title" value="${title!}">
        </label>
        <button type="submit">Search</button>
    </form>
    <div>Список постов</div>
    <#list posts as post>
        <b>${post.id}</b>
        <h2>${post.title}</h2>
        <span>${post.body}</span>
        <strong>${post.authorName}</strong>
        <div>
            <#if post.filename??>
                <img src="/img/${post.filename}" alt="">
            </#if>
        </div>
    <#else>
        No posts
    </#list>
</@common.page>