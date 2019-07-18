# Kollus Live Sample Page
1. 개발 환경
- JDK 1.8 이상
- Spring Boot 2.1.6
- maven
- Thymeleaf 3
- Bootstrap 4.3.1
- JQuery 3.4.1
- Websocket

### 패키지 및 클래스 소개
- api : kollus live api 연동 함수 및 재생 URL 생성 함수
```text
ApiController :: channel 생성된 방송채널 확인 API (/api/channel)
ApiController :: getPlayURL 플레이어 주소 생성 API (/api/jwt)
```
- callback : 라이브 상태 및 녹화파일 전송 콜백 관련 코드
- config : 웹 컨피그, 콜러스 연동을 위한 설정값 클래스
- front : 웹페이지 제어를 위한 컨트롤러
- util : 유틸 함수 및 클래스

### 설정파일
- /src/resources/application.yaml
- 해당 파일의 값들은 콜라스 라이브 콘솔의 [설정->기본정보->서비스계정](https://live-kr.kollus.com/preferences/service_account)에서 확인 가능합니다.
```yaml
kollus:
  clientId:  #OAuth 토큰 획득을위한 사용자 아이디
  clientSecret:  #OAuth 토큰 획득을위한 사용자 비밀번호
  scopes: #API 권한 범위 설정
    - live:control
    - live:statistics
  # Personal Token
  token: 
  serviceAccount:  #서비스계정아이디
  secretKey:  #컨텐츠 재생을위한 비밀키
  customKey:  #URL 검증을위한 키

```

### 실행 방법
```text
$ git clone https://github.com/kollus-service/kollus-live-spring.git
$ cd kollus-live-spring
$ mvn install
$ mvn build
$ mvn springboot:run

```
### 추가 개발 계획
- API 연동 완성
- 콜백 코드 완성
- Front-End 에서 실시간으로 방송상태 확인 및 플레이어 리프레쉬 샘플
- V/G Controller 적용예제 (플레이어 제어 스크립트 적용)
