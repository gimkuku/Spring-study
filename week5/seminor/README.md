# Session 1
## 파일 구조
```
project_name
  ㄴ src
    ㄴ main
      ㄴ java/hjkim/project_name
        ㄴ controller
        ㄴ domain
        ㄴ dto
        ㄴ repository
        ㄴ service
        ㄴ Project_nameApplication.java
      ㄴ resources
        ㄴ static
        ㄴ templates
        ㄴ application.properties
```

## 기능
1. **Controller**
- 사용자에게 받은 요청을 수행할 로직들을 제어하는 객체
- 사용자의 요청을 어떻게 처리할지 결정하는 파트
- `url들을 모아두는 곳`이라고 생각하면 될듯
- 아래 코드를 보면 /users로 온 연락을 userService의 findAllUsers로 보냄
```java
@GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        UsersRes response = new UsersRes(userService.findAllUsers());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
```


2. **Service**
- 실제 어떤 처리를 할지 `비즈니스 로직`이 있는 부분
- DAO를 통해 DB에 접근하고 이를 이용해서 처리한담에 controller에게 그 결과를 반환함 
- 이때 데이터를 주고받는 방식 = **DTO**
```java
@Service
public class UserService {
    private final JdbcUserRepository userRepository;

    @Autowired
    public UserService(JdbcUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){

        return userRepository.findAll();
    }
}
```


3. **Repository** (= DAO)
- 매번 DB에 접근하기 번거로우니, DB에 접근하는 객체들을 모아놓고 이를 호출해서 사용 
- 실제로 `DB에 접근`하는 객체
- JPA 라이브러리 사용시 DAO가 repository로 사용
> Jdbc란?
> 
> `Java DataBase Connectivity`
>
> 자바에서 DB 커넥션을 위해 사용되는 API
```java
// UserRepository.java
public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(Long id);
}

// JdbcUserRepository.java
// UserRepository를 상속받아서 만듬! 
public class JdbcUserRepository implements UserRepository{

    private final DataSource dataSource;

    public JdbcUserRepository(DataSource dataSource){
        this.dataSource =dataSource;
    }

```


4. **DTO**
- 정보를 어떻게 보내주어야 하는지 `포장을 해주는 것`
- 자바는 한번에 여러 반환값을 보낼 수 없음 > DTO로 포장을해서 한번에 최대한 많이 보내기 위해 사용됨
- 직렬화 지점이 될 수 있음
```java
@Getter
public class UserReq {
    private String name;
}
```

