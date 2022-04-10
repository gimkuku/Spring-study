# EFUB 4주차 세미나 과제

###### 백엔드 김현진



### 01. 학사 정보 관리 ERD
![ERD](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/016a3cde-fac8-4bbb-9274-7b805da94710/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-10_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_11.57.32.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220410%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220410T145847Z&X-Amz-Expires=86400&X-Amz-Signature=606ff90a8f87a36e9ba56d581f78294afd3c78392fddd198e879de0e87505e8b&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA%25202022-04-10%2520%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE%252011.57.32.png%22&x-id=GetObject)

- [Draw.io 링크](https://drive.google.com/file/d/1MK_zxTYF7-e09AXAglZt72V7tHrUcplE/view?usp=sharing)

### 02. MySQL 실습 코드

##### SWS 테이블 생성 코드

```

use efub;
create table sws(
	sws_id INT NOT NULL auto_increment,
    name VARCHAR(30) NOT NULL,
    primary key(sws_id)
);
create table member(
	sws_id INT NOT NULL,
    name VARCHAR(45) NOT NULL,
    position VARCHAR(45) NOT NULL,
    email VARCHAR(30),
    birth_date DATE, 
    FOREIGN KEY (sws_id) REFERENCES sws (sws_id)
);

```



##### JOIN 코드

```
select
sws.name as team, member.name as name, member.position, member.email
from
sws join member
on sws.sws_id = member.sws_id;
```



##### JOIN 출력 결과

![JOIN 출력 결과](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9c32ce1c-7bc3-4b54-83b1-49baddc1cf64/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-10_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_11.58.35.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220410%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220410T150146Z&X-Amz-Expires=86400&X-Amz-Signature=94f1b562f42508b5bb4b39d52cfe63ca0667a5dd88929ea28ee1add6ac322586&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA%25202022-04-10%2520%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE%252011.58.35.png%22&x-id=GetObject)