## 1.팀 프로젝트 환경 구성하기 

 ### 1-1  개발환경 체크 
 
[주의사항] </br>
* 로컬 저장소에서 프로젝트를 Import하기 때문에 기존 funny 폴더가 이클립스 Project Explore에 있다면 해당 파일에서 작업중이던 파일을 저장해 다른 곳에 옮겨두세요 모든 설정이 끝나고 작업중이던 파일을 복사하면 됩니다! 
* 폴더 이름이Webapp이면 Import시 오류가 발생합니다 버전을 확인해주세요


[IOS인 경우]</br>
이클립스에서 Git을 사용하기 때문에 IOS도 이클립스 버전, git 로컬 저장소 생성,git Bash 설치 등을 제외하면 윈도우 환경과 비슷합니다. </br>
IOS가 없어 외부 사이트에 의존할 수 밖에 없었습니다. 
 
 
 #### * 개발환경
* 톰캣 - Apache TomCat v9.0
* JDK - JDK or JRE 1.8 버전 
* 이클립스 - [링크](https://jade-frill-5b8.notion.site/89226d07f7ca43e49570371f9991b4b3)




사용 중인 버전이 상위 버전 또는 하위 버전인 경우 링크를 타고 필요한 버전을 다운받으시면 됩니다. [환경 체크](https://jade-frill-5b8.notion.site/4132e489e44942c1b5a592b56520c9db) 

####  * JAR 추가
[JAR 다운로드](https://drive.google.com/file/d/1GffSve-CvsH2sk2xp4g9msxo2RSpbpFO/view?usp=sharing)에서 개발에 필요한 JAR을 다운로드할 수 있습니다. 
압출을 풀고 C드라이브에 넣어두면 프로젝트 생성 시 자동으로 인식합니다 </br>
만약 인식하지 않는다면 아래 링크를 참고해 프로젝트에 추가해 주세요

개발에 필요한 JAR 파일은 구글 드라이브에 있습니다. 
[JAR 다운로드](https://drive.google.com/file/d/1GffSve-CvsH2sk2xp4g9msxo2RSpbpFO/view?usp=sharing)

[IOS인 경우]</br>
[프로젝트에 JAR 적용 방법](https://kamang-it.tistory.com/74)

[win OS인 경우]</br>
[프로젝트에 JAR 적용 방법](https://veneas.tistory.com/entry/Eclipse-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EC%97%90-jar-%ED%8C%8C%EC%9D%BC-%EC%B6%94%EA%B0%80%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95-%EC%9E%90%EB%B0%94-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%B6%94%EA%B0%80)

### 1-2 github 연동  
#### [github 연동 설정](https://jade-frill-5b8.notion.site/GitHub-b8e39ce43cc54cceaddcafdf2fd67e13)




## 2. 파일 업로드 & 다운로드 방법 
### 버전을 관리하게 되면 main or develop branch인지 확인하셔야됩니다. 

[주의사항] 
파일 업로드 전 Pull로 원본 저장소와 동기화 해야합니다!
버전이 안맞으면 충돌이 생깁니다.

### 2-1 파일 업로드 
#### [파일 업로드 방법](https://jade-frill-5b8.notion.site/github-703a7ab684af428a946d264b5acf09c8)



### 2-2 파일 다운로드 
#### [파일 다운로드 방법](https://jade-frill-5b8.notion.site/github-8cc4f41cf067407981ffe687f351cdf2)

### 2-2 파일 Pull Request
#### [원본 저장소에 Pull Request](https://jade-frill-5b8.notion.site/pull-request-b67a6502701842f983875705e090a544)


## 3. git-flow 사용 
### 3-1 git-flow와 github-flow 차이 
[링크](https://ujuc.github.io/2015/12/16/git-flow-github-flow-gitlab-flow/)


### 3-2 git-flow 전략
우아한 형제들 기술 블로그에서 git-flow 전략에 대한 설명을 하고 있어서 팀 프로젝트에 적용해보면 좋을 것 같습니다. 
[우하한 형제들 git-flow 전략](https://techblog.woowahan.com/2553/) </be>

### 3



### git flow 이용
사용중인 Repository와 Branch 
* Repositories
  - upstream (Upstream Repository)
  - origin (Origin Repository)

* Branches
  - main (서버에서 실행시켜도 문제가 없는 버전)
  - develop (개발중인 버전)

## 4. branch 생성(수정중)


[git 저장소 구성](https://drive.google.com/file/d/1DBgr3Qsy5K0FAlXdRBB4KP8mKyVZihoe/view?usp=sharing)

[git flow](https://jade-frill-5b8.notion.site/Git-Flow-81926030787645cc83af3a07e149d061)


### 4-1 branch 이름 
* main branch - 오류없는 버전 (실행시켜도 에러가 없는 버전)
* Develop branch - 개발중인 버전 
* [팀원 이름으로 만든 branch] - (예정)

### 4-2 branch flow
???? -  
[링크](https://drive.google.com/file/d/111jBVqB6p011tJl1JId_34WnLQG2ggDU/view?usp=sharing)

#### git-flow 
git-flow (https://techblog.woowahan.com/2553/)

### 3-3 branch 생성 및 사용 방법

#### 3-3-1 로컬 저장소에 branch 생성 

* 로컬 저장소 branch 병합(merge)

* 내 깃허브에 병합된 branch push 

#### 3-3-2 내 깃허브에 branch 생성 


#### 추가 예정

* branch 이해 -
[참고 링크](https://jade-frill-5b8.notion.site/branch-f32dc919d483401280c4dd38b3c1ec17)
* 깃flow을 위한 GUI 툴 [GFC](https://www.sourcetreeapp.com/)(미정)



## 3. COMMIT 메시지 작성 규칙

