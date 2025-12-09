# ChzzkHub-API-Server-Spring

치지직(Chzzk) 방송 합방 멤버 구하기 플랫폼의 Spring 기반 API 서버 프로젝트입니다.  
스트리머들이 보다 쉽게 합방 멤버를 모집하고, 크루/친구 관리 및 메시지 전송을 지원합니다.

---

## 🚀 기술 스택
- **Framework**: Spring Boot 3.5.5
- **Language**: Java 17
- **Database**: MySQL 8.0+
- **Cache & Session**: Redis
- **Build Tool**: Gradle
- **Frontend**: Thymeleaf + Bootstrap 5 + JavaScript
- **API 문서화**: Spring REST Docs (예정)
- **인증/인가**: JWT 기반

---
## 📌 주요 기능

### 1. 사용자(User)
- 치지직 스트리머 인증
- 로그인
- 로그아웃

### 2. 크루(Crew)
- 크루 생성 및 관리
- 크루원 초대 / 삭제
- 크루 해체
- 크루 공지 등록

### 3. 친구(Friend)
- 친구 초대 및 수락
- 친구 삭제
- 1:1 메시지 전송

### 4. 합방(Collaboration / Co-Streaming)
- 합방 방 생성
    - **크루 합방**: 크루 단위로 합방 생성
    - **번개 합방**: 즉석 합방(친구들만 초대 가능능) 생성
    - **공개 합방**: 전체 공개 합방 모집
- 초대 메시지 전송
    - **치즈허브(내부 플랫폼)**
    - **디스코드 Webhook 연동**
- 합방 정보 관리
    - 카테고리, 인원 수, 일정, 공지, 상세 내용 등록
- 상태 관리
    - 합방 모집 / 취소 / 완료 처리

---

## 🎨 프론트엔드 기능(Cursor AI로 개발)

### 웹 페이지 구성
- **메인 페이지** (`/`): 플랫폼 소개 및 주요 기능 안내
- **로그인 페이지** (`/login`): 치지직 스트리머 인증 및 로그인
- **크루 관리** (`/crew`): 크루 생성, 관리, 멤버 초대/삭제
- **친구 관리** (`/friend`): 친구 추가, 메시지 전송, 상태 관리
- **합방 관리** (`/collaboration`): 합방 생성, 초대, 상태 관리

### UI/UX 특징
- **반응형 디자인**: 모바일, 태블릿, 데스크톱 지원
- **모던한 UI**: Bootstrap 5 기반의 깔끔한 디자인
- **직관적인 네비게이션**: 사용자 친화적인 메뉴 구성
- **실시간 피드백**: 로딩 상태, 알림 메시지, 상태 표시
- **애니메이션 효과**: 부드러운 전환 효과 및 호버 애니메이션

### 주요 컴포넌트
- **카드 기반 레이아웃**: 정보를 구조화된 카드로 표시
- **모달 다이얼로그**: 폼 입력 및 상세 정보 표시
- **드롭다운 메뉴**: 액션 버튼 및 필터링 옵션
- **배지 시스템**: 상태 및 카테고리 표시
- **아바타 시스템**: 사용자 프로필 이미지 표시

---

## DB 설계

### 📊 Entity Relationship Diagram
**ERDCloud에서 직접 보기**: [ChzzkHub Database Schema](https://www.erdcloud.com/p/xgAq475HHrSBvQLC9)
- 업데이트
  - 2025-09-21 특정 테이블에 생성시간, 업데이트 시간 업데이트


### 📊 주요 테이블 구성

- **USERS**: 사용자 정보 (치지직 스트리머)
- **CREW**: 크루 정보 및 관리
- **CREW_REQUEST**: 크루 가입 요청
- **CREW_MEMBER**: 크루 멤버십
- **FRIEND**: 친구 관계
- **FRIEND_REQUEST**: 친구 요청
- **COLLABORATION**: 합방 정보
- **COLLABORATION_MEMBER**: 합방 참여자
- **COLLABORATION_REQUEST**: 합방 요청


## 🚀 실행 방법

### 1. 프로젝트 클론 및 빌드
```bash
git clone [repository-url]
cd ChzzkHub-API-Server-Spring
./gradlew build
```

### 2. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 3. 웹 브라우저에서 접속
- **메인 페이지**: http://localhost:8080
- **로그인 페이지**: http://localhost:8080/login
- **크루 관리**: http://localhost:8080/crew
- **친구 관리**: http://localhost:8080/friend
- **합방 관리**: http://localhost:8080/collaboration

### 4. 개발 환경 설정
- **IDE**: IntelliJ IDEA 또는 Eclipse
- **Java**: JDK 17 이상
- **Gradle**: 프로젝트에 포함된 Gradle Wrapper 사용

---

## 📁 프로젝트 구조

### 🏛️ 클린 아키텍처 (Clean Architecture)

이 프로젝트는 **헥사고날 아키텍처**(Hexagonal Architecture) 기반의 클린 아키텍처를 적용하여 구현되었습니다.

#### 📐 아키텍처 다이어그램

```
┌─────────────────────────────────────────────────────────────┐
│                     Adapter Layer (외부 계층)                  │
│                                                               │
│  ┌─────────────────────┐         ┌────────────────────────┐ │
│  │   Inbound Adapter   │         │   Outbound Adapter     │ │
│  │  (Web Controller)   │         │ (Persistence Adapter)  │ │
│  │                     │         │                        │ │
│  │  - REST API 처리    │         │  - DB 접근             │ │
│  │  - HTTP 요청/응답   │         │  - JPA 구현            │ │
│  └──────────┬──────────┘         └──────────▲─────────────┘ │
│             │                               │                │
└─────────────┼───────────────────────────────┼────────────────┘
              │                               │
              ▼                               │
┌─────────────────────────────────────────────┼────────────────┐
│            Application Layer (애플리케이션 계층)  │                │
│                                             │                │
│  ┌──────────────────┐          ┌───────────┴─────────────┐  │
│  │  Inbound Port    │          │    Outbound Port        │  │
│  │   (UseCase)      │          │  (Repository Interface) │  │
│  │                  │          │                         │  │
│  │  - 기능 정의      │          │  - DB 인터페이스        │  │
│  └────────▲─────────┘          └──────────┬──────────────┘  │
│           │                               │                 │
│           │    ┌──────────────────────┐   │                 │
│           └────│   Service (구현체)    │───┘                 │
│                │  - 비즈니스 로직      │                     │
│                └──────────────────────┘                     │
│                           │                                 │
└───────────────────────────┼─────────────────────────────────┘
                            ▼
┌─────────────────────────────────────────────────────────────┐
│                  Domain Layer (도메인 계층)                    │
│                                                               │
│                    ┌──────────────┐                          │
│                    │   Entity     │                          │
│                    │  - Users     │                          │
│                    │  - Crew      │                          │
│                    │  - Friend    │                          │
│                    └──────────────┘                          │
└─────────────────────────────────────────────────────────────┘
```

#### 🎯 핵심 개념

**1. Port (포트)** - 인터페이스
- **Inbound Port**: 애플리케이션이 제공하는 기능 (UseCase 인터페이스)
- **Outbound Port**: 애플리케이션이 필요로 하는 기능 (Repository 인터페이스)

**2. Adapter (어댑터)** - 구현체
- **Inbound Adapter**: 외부 요청을 애플리케이션으로 전달 (Controller)
- **Outbound Adapter**: 애플리케이션의 요청을 외부로 전달 (Repository 구현체)

**3. 의존성 방향** - 단방향 의존
```
Adapter (외부) → Application (Port) → Domain (핵심)
```
- 핵심 비즈니스 로직(Domain)은 외부 기술에 의존하지 않음
- 외부 기술(DB, API)은 교체 가능하도록 설계

---

### 📂 디렉토리 구조

```
src/main/java/com/gajamy/ChzzkHub/
│
├── 📁 domain/                              # 도메인 계층 (핵심 비즈니스 엔티티)
│   ├── BaseEntity.java                    # 공통 엔티티 (생성/수정 시간)
│   ├── user/entity/
│   │   └── Users.java                     # 사용자 엔티티
│   ├── crew/entity/
│   │   ├── Crew.java                      # 크루 엔티티
│   │   ├── CrewMember.java                # 크루 멤버 엔티티
│   │   └── CrewRequest.java               # 크루 가입 요청 엔티티
│   ├── friend/entity/
│   │   ├── Friend.java                    # 친구 관계 엔티티
│   │   └── FriendRequest.java             # 친구 요청 엔티티
│   └── collaboration/entity/
│       ├── Collaboration.java             # 합방 엔티티
│       ├── CollaborationMember.java       # 합방 참여자 엔티티
│       └── CollaborationRequest.java      # 합방 참여 요청 엔티티
│
├── 📁 application/                         # 애플리케이션 계층 (비즈니스 로직)
│   ├── port/                              # Port 인터페이스
│   │   ├── in/                            # Inbound Port (UseCase)
│   │   │   └── user/
│   │   │       ├── CreateUserUseCase.java  # 사용자 생성 기능
│   │   │       ├── GetUserUseCase.java     # 사용자 조회 기능
│   │   │       ├── UpdateUserUseCase.java  # 사용자 수정 기능
│   │   │       └── DeleteUserUseCase.java  # 사용자 삭제 기능
│   │   │
│   │   └── out/                           # Outbound Port (Repository Interface)
│   │       └── user/
│   │           ├── LoadUserPort.java       # 사용자 조회 저장소 인터페이스
│   │           ├── SaveUserPort.java       # 사용자 저장 저장소 인터페이스
│   │           └── DeleteUserPort.java     # 사용자 삭제 저장소 인터페이스
│   │
│   ├── service/                           # Service (UseCase 구현체)
│   │   └── user/
│   │       └── UserService.java           # 사용자 비즈니스 로직
│   │
│   └── dto/                               # Data Transfer Object
│       └── user/
│           ├── request/
│           │   ├── CreateUserRequest.java  # 사용자 생성 요청 DTO
│           │   └── UpdateUserRequest.java  # 사용자 수정 요청 DTO
│           └── response/
│               └── UserResponse.java       # 사용자 응답 DTO
│
├── 📁 adapter/                             # 어댑터 계층 (외부 인터페이스)
│   ├── in/                                # Inbound Adapter
│   │   └── web/                           # Web Adapter (HTTP)
│   │       └── user/
│   │           └── UserController.java     # REST API Controller
│   │
│   └── out/                               # Outbound Adapter
│       └── persistence/                   # Persistence Adapter (DB)
│           └── user/
│               ├── UserJpaRepository.java      # Spring Data JPA Repository
│               └── UserPersistenceAdapter.java # Port 구현체 (Adapter)
│
├── 📁 global/                              # 전역 설정 및 공통 모듈
│   ├── config/
│   │   └── JpaConfig.java                 # JPA 설정
│   ├── exception/
│   │   ├── BusinessException.java         # 비즈니스 예외
│   │   └── GlobalExceptionHandler.java    # 전역 예외 처리
│   └── common/
│       └── BaseEntity.java                # 공통 엔티티
│
├── 📁 interfaces/controller/               # 기존 웹 페이지 컨트롤러
│   └── WebController.java                 # Thymeleaf 페이지 렌더링
│
└── ChzzkHubApplication.java               # Spring Boot 메인 클래스

resources/
├── application.properties                 # 애플리케이션 설정
├── static/                                # 정적 리소스
│   ├── css/style.css
│   └── js/main.js
└── templates/                             # Thymeleaf 템플릿
    ├── layout.html
    ├── index.html
    ├── login.html
    ├── crew.html
    ├── friend.html
    └── collaboration.html
```

---

### 🔄 User 도메인 예시로 보는 데이터 흐름

#### 1️⃣ **사용자 생성 API 호출 시 흐름**

```
HTTP POST /api/users
    ↓
[Inbound Adapter] UserController
    - HTTP 요청을 받아서 CreateUserRequest DTO로 변환
    - CreateUserUseCase 호출
    ↓
[Application Layer] UserService (implements CreateUserUseCase)
    - 비즈니스 로직 실행 (유효성 검증, 중복 체크 등)
    - Users 엔티티 생성
    - SaveUserPort 호출
    ↓
[Outbound Adapter] UserPersistenceAdapter (implements SaveUserPort)
    - UserJpaRepository를 사용하여 DB에 저장
    - Users 엔티티 반환
    ↓
[Application Layer] UserService
    - Users 엔티티를 UserResponse DTO로 변환
    - 결과 반환
    ↓
[Inbound Adapter] UserController
    - UserResponse를 HTTP 응답으로 변환
    ↓
HTTP 200 OK + UserResponse JSON
```

#### 2️⃣ **각 계층별 코드 예시**

**Inbound Adapter (Controller)**
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserResponse response = createUserUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
```

**Inbound Port (UseCase Interface)**
```java
public interface CreateUserUseCase {
    UserResponse execute(CreateUserRequest request);
}
```

**Application Service (UseCase 구현)**
```java
@Service
public class UserService implements CreateUserUseCase {
    private final LoadUserPort loadUserPort;
    private final SaveUserPort saveUserPort;

    @Override
    public UserResponse execute(CreateUserRequest request) {
        // 비즈니스 로직
        Users user = Users.builder()
            .id(request.getId())
            .profile(request.getProfile())
            .followers(0)
            .build();

        Users savedUser = saveUserPort.saveUser(user);
        return UserResponse.from(savedUser);
    }
}
```

**Outbound Port (Repository Interface)**
```java
public interface SaveUserPort {
    Users saveUser(Users user);
}
```

**Outbound Adapter (Persistence Adapter)**
```java
@Component
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort {
    private final UserJpaRepository jpaRepository;

    @Override
    public Users saveUser(Users user) {
        return jpaRepository.save(user);
    }
}
```

**Spring Data JPA Repository**
```java
public interface UserJpaRepository extends JpaRepository<Users, String> {
    // Spring Data JPA가 자동으로 구현
}
```

---

### ✅ 클린 아키텍처의 장점

1. **테스트 용이성**: 각 계층을 독립적으로 테스트 가능
2. **유연성**: DB를 JPA → MyBatis로 변경해도 Application 계층은 수정 불필요
3. **명확한 책임 분리**: 각 계층의 역할이 명확함
4. **도메인 중심**: 비즈니스 로직이 기술에 의존하지 않음
5. **확장성**: 새로운 기능 추가 시 일관된 패턴으로 개발 가능

---

## 🔧 개발 도구 및 라이브러리

### Frontend Dependencies
- **Bootstrap 5.3.0**: CSS 프레임워크
- **Font Awesome 6.0.0**: 아이콘 라이브러리
- **Thymeleaf**: 서버사이드 템플릿 엔진

### Backend Dependencies
- **Spring Boot Starter Web**: 웹 애플리케이션 개발
- **Spring Boot Starter Thymeleaf**: 템플릿 엔진
- **Spring Boot Starter Data JPA**: 데이터베이스 연동
- **H2 Database**: 인메모리 데이터베이스 (개발용)
- **Lombok**: 코드 간소화


