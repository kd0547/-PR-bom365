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


## 3. git-flow  
### 3-1 git-flow와 github-flow 차이 
[링크](https://ujuc.github.io/2015/12/16/git-flow-github-flow-gitlab-flow/)


### 3-2 git-flow 전략 예시 
우아한 형제들 기술 블로그에서 git-flow 전략에 대한 설명을 하고 있어서 팀 프로젝트에 적용해보면 좋을 것 같습니다. 
[우하한 형제들 git-flow 전략](https://techblog.woowahan.com/2553/) </br>

### 3-3 Git Repository 구성 살펴보기
Local Repository에서 작업을 완료한 후 origin Repository push 합니다. 
그리고 GitHub에서 Origin Repository에 push한 브랜치를 Upstream Repository로 merge하는 Pull Request를 생성하고 
주 3회 있는 회의에서 팀원들과 회의 후 merge 합니다. 
다시 새로운 작업을 진행할 때 Local Repository에서 Upstream Repository를 pull 합니다. 

[Git Repository 구성](https://drive.google.com/file/d/1DBgr3Qsy5K0FAlXdRBB4KP8mKyVZihoe/view?usp=sharing)





### git flow 사용
사용중인 Repository와 Branch 
* Repositories
  - upstream (Upstream Repository)
  - origin (Origin Repository)

* Branches
  - main (서버에서 실행시켜도 문제가 없는 버전)
  - develop (개발중인 버전)

#### git-flow 
git-flow (https://techblog.woowahan.com/2553/)
[git flow](https://jade-frill-5b8.notion.site/Git-Flow-81926030787645cc83af3a07e149d061)

## 4. branch 사용하기 

### 4-1 branch 이름 
* main branch - 오류없는 버전 (실행시켜도 에러가 없는 버전)
* Develop branch - 개발중인 버전 
* fixed branch - 버그 수정 버전 


###  4-2 로컬에서 branch 사용하기
로컬 브랜치에서 사용하는 방법을 올렸습니다.</br>
[로컬 브랜치 사용하기](https://jade-frill-5b8.notion.site/06c7833df9b343f9a1768d01fb7d7b3d)

### 4-3 깃허브 저장소에서 branch 사용하기
[깃허브에서 브랜치 사용하기](https://jade-frill-5b8.notion.site/branch-37316ce5e31c43cc903e37d10b2b2bdd)


### 4-4 branch 사용 예시(추가중)




## 5. COMMIT 메시지 작성 규칙
[블로그 링크](https://junhyunny.github.io/information/github/git-commit-message-rule/#22-%EC%A0%9C%EB%AA%A9subject)
에서 commit 작성 규칙이 있어 팀 프로젝트에서도 적용할 예정입니다.

### 5-1 타입 
* Feat - 새로운 기능 추가
* Fix - 버그 수정
* Build - 빌드 관련 파일 수정
* Ci - CI관련 설정 수정
* Docs - 문서 (문서 추가, 수정, 삭제)
* Style - 스타일 (코드 형식, 세미콜론 추가: 비즈니스 로직에 변경 없는 경우)
* Refactor - 코드 리팩토링
* Test - 테스트 (테스트 코드 추가, 수정, 삭제: 비즈니스 로직에 변경 없는 경우)
* Chore - 기타 변경사항 (빌드 스크립트 수정 등)

### 5-2 제목(Subject)
* 제목은 50자를 넘기지 않고, 마침표를 붙이지 않습니다.
* 제목에는 commit 타입을 함께 작성합니다.
* 과거 시제를 사용하지 않고 명령조로 작성합니다.
* 제목과 본문은 한 줄 띄워 분리합니다.
* 제목의 첫 글자는 반드시 대문자로 씁니다.
* 제목이나 본문에 이슈 번호(가 있다면) 붙여야 합니다.

### 5-3 본문(Body)
* 선택 사항이기에 모든 commit에 본문 내용을 작성할 필요는 없습니다.
* 한 줄에 72자를 넘기면 안 됩니다.
* 어떻게(How)보다 무엇을, 왜(What, Why)에 맞춰 작성합니다.
* 설명뿐만 아니라, commit의 이유를 작성할 때에도 씁니다.


### 5-3 꼬리말(Footer)
* 선택 사항이므로 모든 commit에 꼬리말을 작성할 필요는 없습니다.
* Issue tracker ID를 작성할 때 사용합니다.
* 해결: 이슈 해결 시 사용
* 관련: 해당 commit에 관련된 이슈 번호
* 참고: 참고할 이슈가 있는 경우 사용

### 5-4 작성 예시 (추가중)
#### 자기코드번호+m/v/c+타입

#### 추가 예정

* branch 이해 -
[참고 링크](https://jade-frill-5b8.notion.site/branch-f32dc919d483401280c4dd38b3c1ec17)
* 깃flow을 위한 GUI 툴 [GFC](https://www.sourcetreeapp.com/)(미정)

