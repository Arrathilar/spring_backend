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
        <div class="collapse <#if message??>show</#if>" id="createPost">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">Загаловок</label>
                    <input class="form-control ${(titleError??)?string('is-invalid', '')}"
                           value="<#if message??>${message.title}</#if>"
                           id="title" type="text" name="title" placeholder="Введите заголовок">
                    <#if titleError??>
                    <div class="invalid-feedback">
                        ${titleError}
                    </div>
                    </#if>
                </div>
                <div class="form-group">
                    <label for="body">Тело поста</label>
                    <input class="form-control ${(bodyError??)?string('is-invalid', '')}" id="body"
                           value="<#if message??>${message.body}</#if>"
                           type="text" name="body" placeholder="Введите пост">
                    <#if bodyError??>
                        <div class="invalid-feedback">
                            ${bodyError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <label for="tag">Теги поста</label>
                    <input class="form-control ${(tagError??)?string('is-invalid', '')}" id="tag"
                           value="<#if message??>${message.tag}</#if>"
                           type="text" name="tag" placeholder="Введите тег">
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${tagError}
                        </div>
                    </#if>
                </div>
                <div class="custom-file">
                    <label for="file">Изображение</label>
                    <input type="file" class="custom-file-input" id="file" name="file">
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