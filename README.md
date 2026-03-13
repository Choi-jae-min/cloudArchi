### CloudArchi Platform
CloudArchi Platform은 AWS 기반 인프라 환경에서 Spring Boot 애플리케이션을 안정적으로 배포하고 운영하기 위한 클라우드 아키텍처 실습 프로젝트입니다.
Docker 기반 컨테이너 배포, GitHub Actions 기반 CI/CD, AWS 서비스(S3, RDS, ALB, ASG 등)를 활용하여 클라우드 환경에서의 애플리케이션 운영 흐름을 구현하는 것을 목표로 하였습니다.

---

### 프로젝트 목표

#### ☁️ 클라우드 환경 배포 경험
Spring Boot 애플리케이션을 AWS 인프라 환경에서 Docker container 기반으로 배포하고 운영

#### 🔄 자동화된 배포 파이프라인 구축
GitHub Actions를 활용하여 코드 변경 시 자동 빌드 및 배포가 이루어지는 CI/CD 파이프라인 구성

#### 🛡 인프라 보안 설계 경험
RDS 보안 그룹을 EC2로 제한하여 데이터베이스 접근을 애플리케이션 서버로만 허용하고 EC2 또한 Private Subnet에 두어 외부 접근 차단

#### ⚖️ 로드 밸런싱 기반 트래픽 분산 경험
Application Load Balancer를 도입하여 다수의 EC2 인스턴스로 요청을 분산하고, 단일 서버 구조의 한계를 보완하는 트래픽 처리 구조 구현

#### 📈 오토 스케일링 기반 확장성 확보
Auto Scaling Group을 구성하여 인스턴스 수를 유연하게 조절할 수 있는 구조를 설계하고, 트래픽 변화에 대응 가능한 확장 환경 구축

#### 🌐 사용자 도메인 연결 경험
Route 53을 활용하여 서비스 도메인을 연결하고, 사용자가 고정된 IP 대신 도메인 기반으로 애플리케이션에 접근할 수 있는 환경 구성,
ACM을 활용해 SSL 인증서를 적용하고 사용자 요청을 암호화된 연결로 처리할 수 있도록 설정

#### 🗂 클라우드 스토리지 및 CDN 활용
S3와 CloudFront를 활용하여 이미지 업로드 및 정적 리소스 제공 환경을 구성하고, 스토리지와 CDN을 분리한 서비스 구조 경험

---

### 아키텍쳐

지금 과정에서 제가 배우고 생각한 구조를 그려보았습니다.

<img width="2001" height="830" alt="Image" src="https://github.com/user-attachments/assets/c56860a9-ec28-47ba-99f1-cb09bd3281ed" />
---

### 사용 기술 스택
| 구분                          | 기술                                                        |
| --------------------------- | --------------------------------------------------------- |
| **Backend**                 | Java 17, Spring Boot 3.x.x                                |
| **Database**                | MySQL (Amazon RDS)                                        |
| **Infrastructure**          | Amazon EC2, Docker, Auto Scaling Group, Application Load Balancer |
| **Storage**                 | Amazon S3, Amazon CloudFront                              |
| **Network / DNS**           | Amazon Route 53,AWS ACM (SSL 인증서)                       |
| **CI/CD**                   | GitHub Actions, Docker Hub                                |

#### 스택 선정 이유

#### AWS 
실무에서 가장 많이 사용하는 클라우드 환경을 경험하고 구축하고 이해하기 위해

#### Docker 
애플리케이션 실행 환경을 컨테이너로 패키징하여 배포 환경 일관성 확보하기 위해 

#### GitHub Actions 
다른자동화 도구에비해 러닝커브가 낮고, 바로 빠르게 적용이가능해서

#### Spring Boot 3.x.x
4버전대 보다 커뮤니티가 활성화 되어있고 안정성이 더 좋다고 생각되어서

---

##과제 제출 요구사항

### Lv 0. 
요금 폭탄을 맞지않기 위해 budget을 설정 해 주었습니다.
1. 설정 완료된 AWS Budgets 화면을 캡처하여 README.md에 첨부하세요.
기존 85% -> 80 에서 알림이 오도록 설정하였습니다
<img width="1405" height="598" alt="Image" src="https://github.com/user-attachments/assets/aa4f0f1d-0d26-4e64-b44c-f0fef666337d" />

### Lv 1. 
ec2서버를 실행시키고
profile을 분리하고 interceptor에서 로그를 작성 하였습니다.
1. 설정 완료된 EC2의 퍼블릭 IP 를 README.md에 첨부하세요.

IP : 52.79.75.227
<img width="2068" height="512" alt="Image" src="https://github.com/user-attachments/assets/ff86fed8-7b10-4413-b3c0-93aa648f76cc" />

### Lv 2.
RDS DB서버를 구축하고 EC2 보안그룹을 인바운드 규칙에 넣어 보안그룹 체이닝을 경험 하였습니다. 
또한 DB 엔드포인트등 중요한 정보를 parametorStore 에 저장하고 불러올 수 있도록 하였습니다.

1. Parameter Store에 저장한 team-name 값이 /actuator/info 엔드포인트에서 조회되도록 설정하세요.

address : http://52.79.75.227:8080/actuator/info
<img width="1027" height="171" alt="image" src="https://github.com/user-attachments/assets/f4cef692-7103-4640-9f3b-0173bf0ef5d7" />
<img width="683" height="476" alt="image" src="https://github.com/user-attachments/assets/fef8cf03-7ce8-4abd-8c17-dd32131cd486" />

3. 소스(Source) 부분에 IP 주소(0.0.0.0/0)가 아닌, EC2의 보안 그룹 ID (sg-xxxxx)가 등록되어 있음을 보여주어야 합니다.
<img width="3394" height="1128" alt="Image" src="https://github.com/user-attachments/assets/cd972ad3-9ae4-4ef4-a085-446264eca336" />

### Lv 3.
S3를 **퍼블릭 차단**으로 생성하고 S3 접근 권한이 있는 IAM Role을 생성해 EC2에 연결하였습니다.
POST , GET /api/members/{memberId}/profile-image 엔드포인트를 통해 이미지를 업로드하고 다운 받을 수 있도록 하였습니다
1. S3 이미지 접근 성공 스크린샷을 확보하여 README.md 에 첨부
<img width="1996" height="829" alt="Image" src="https://github.com/user-attachments/assets/ed25c013-56c6-4b0e-89bd-ef948e878292" />

## 도전 과제

### Lv 4.
github actions 에 workflows를 활용하여 CI/CD 를 구축하였습니다. 러너 서버가 자동으로 이미지를 빌드하고
도커 허브에 로그인하여 생성한 이미지를 push하고 SSM 을 통해 private ec2에 접속해 도커 이미지를 pull하고 컨테이너를 실행 시켰습니다.
1.  Actions 탭에서 배포 워크플로우가 초록색 체크(Success)로 표시된 화면을 캡처 후 README.md에 올려 주세요
<img width="1044" height="635" alt="Image" src="https://github.com/user-attachments/assets/b4163d08-83e9-482d-8fb1-b0a46e23ae2d" />

2. sudo docker ps 명령어를 입력했을 때, 실행 중인 컨테이너 목록이 나오는 화면을 캡처 후 README.md에 올려 주세요
<img width="2098" height="96" alt="Image" src="https://github.com/user-attachments/assets/66806a17-385d-46f0-8c97-19d3058fdb3a" />

### Lv 5.
기존 public 서브넷에 있던 EC2,RDS를 private으로 옮기고 natGateWay를 통해 외부로 요청만 가능한 상태로 하였습니다
또한 고대디에서 도매인을 구매하여 AWS 호스팅영역에 끌고와 ACM SSL인증서를 발급받고
ALB를 해당 VPC의 퍼블릭 서브넷에 EC2앞에두어서 ALB를 통해 ec2에 접속 가능하도록 제작 하였고 서버가 특정 cpu사용량을 넘을경우 트래픽을 분산 하도록 하였습니다.
또한 ASG의 시작 템플릿을 제작하여 ALB와 연결하여 트래픽이나 CPU 사용량에 따라 EC2가 자동으로 생성/삭제되도록 구성 하였습니다.

1. HTTPS 적용된 도메인 URL

   https://api.godofsparta.click/actuator/health
   
3. Target Group(대상 그룹) 이미지
<img width="2286" height="892" alt="Image" src="https://github.com/user-attachments/assets/395e65e8-ca24-4f94-8f59-8f7d0982dadf" />

### Lv 6.
1. CloudFront 이미지 URL
   
   https://godofsparta.click/uploads/1127dd43-849b-4385-b143-af16c03588f1_%EA%B0%95%EC%A5%90.jpg

----------------
### 실행 방법
저장소 클론 후 아래 정보를 yml 파일에 입력 해주어야합니다.
```
      app:
        s3:
          bucket: YOUR-BUCKET-NAME
        cloudfront:
          url: YOUR-CND-URL
      
      spring: -> aws 자격증명 aws configure 사용 
        cloud:
          aws:
            region:
              static: ap-northeast-2
      
        datasource: -> local.yml 인경우 h2 DB
          url: jdbc:h2:mem:testdb
          driver-class-name: org.h2.Driver
          username: sa
          password:
      
        h2:
          console:
            enabled: true
            path: /h2-console
      
        jpa:
          hibernate:
            ddl-auto: create-drop
          show-sql: true
          properties:
            hibernate:
              format_sql: true
      
      management:
        endpoints:
          web:
            exposure:
              include: health

```
