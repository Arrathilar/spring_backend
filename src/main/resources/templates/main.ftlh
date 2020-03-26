<#import "parts/common.ftlh" as common>

<@common.page>
    <div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form method="get" action="/main" class="form-inline">
                    <input class="form-control" type="text" name="title" value="${title!}" placeholder="Search by title">
                    <button type="submit" class="btn btn-primary ml-4">Search</button>
                </form>
            </div>
        </div>
        <a class="btn btn-primary" data-toggle="collapse" href="#createPost" role="button" aria-expanded="false" aria-controls="createPost">
            Add new post
        </a>
        <div class="collapse" id="createPost">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">Загаловок</label>
                    <input class="form-control" id="title" type="text" name="title" placeholder="Введите заголовок">
                </div>
                <div class="form-group">
                    <label for="body">Тело поста</label>
                    <input class="form-control" id="body" type="text" name="body" placeholder="Введите пост">
                </div>
                <div class="form-group">
                    <label for="tag">Теги поста</label>
                    <input class="form-control" id="tag" type="text" name="tag" placeholder="Введите тег">
                </div>
                <div class="custom-file">
                    <label for="file">Изображение</label>
                    <input type="file" class="custom-file-input" id="file" name="file" required>
                    <label class="custom-file-label" for="file">Choose file...</label>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
    <#list posts as post>
        <div class="card mt-4">
            <div class="card-body">
                <#if post.filename??>
                    <img class="card-img-top" src="/img/${post.filename}" alt="">
                </#if>
                <h5 class="card-title">
                    ${post.title}
                </h5>
                <p class="card-text">${post.body}</p>
                <small>${post.authorName}</small>
            </div>
        </div>
    <#else>
        No posts
    </#list>
</@common.page>