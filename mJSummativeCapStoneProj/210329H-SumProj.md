## Ternary operators 

### some thymeleaf exmaples
#### hires.html
``` html
    <!-- <td th:text="${hire.casedone == true ? ('YES') : hidden}"/> -->
    <td th:text="${ hire.casedone == true ?  hire.hireId : '' }" />

    <td><a th:classappend="${hire.casedone != true ? 'btn btn-info btn-sm fa fa-edit' : hidden}"
        th:href="@{'/hireEdit/' + ${hire.hireId}}"> </a>
    <!-- <a th:classappend="${hire.casedone == true ? '' : 'btn btn-info btn-sm'}"
        th:href="@{'/hireEdit/' + ${hire.hireId}}">
        <span class="fa fa-edit"></span></a> -->	
```
#### Thymeleaf Page Layouts
https://www.thymeleaf.org/doc/articles/layouts.html
``` java
@Controller
class HomeController {

    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }

}
```
``` html
            <li th:classappend="${module == 'home' ? 'active' : ''}">
              <a href="#" th:href="@{/}">Home</a>
            </li>
            <li th:classappend="${module == 'tasks' ? 'active' : ''}">
              <a href="#" th:href="@{/task}">Tasks</a>
            </li>

<div th:replace="fragments/footer :: ${#authentication.principal.isAdmin()} ? 'footer-admin' : 'footer'">
  &copy; 2016 The Static Templates
</div>

<div th:replace="${#authentication.principal.isAdmin()} ? ~{fragments/footer :: footer-admin} : ~{fragments/footer :: footer-admin}">
  &copy; 2016 The Static Templates
</div>


```
