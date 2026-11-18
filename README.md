# OOP2_YachtDice
객체지향언어2 팀플

---

# GitHub Desktop 사용 가이드

## 1. 기본 용어

| 용어 | 뜻 |
|---|---|
| **Repository (리포지토리)** | 프로젝트 폴더. 코드와 변경 기록이 모두 들어 있음 |
| **origin** | GitHub 서버에 있는 원격 리포지토리 |
| **Branch (브랜치)** | 독립된 작업 공간. 다른 사람 코드에 영향 없이 작업할 수 있음 |
| **main** | 최종 완성본이 모이는 기본 브랜치. **직접 작업하지 않습니다** |
| **Commit (커밋)** | 변경사항을 "저장 지점"으로 기록하는 것 (내 컴퓨터에만 저장됨) |
| **Push (푸시)** | 내 컴퓨터의 커밋을 GitHub에 올리는 것 |
| **Fetch (페치)** | GitHub에 새 변경사항이 있는지 확인만 하는 것 |
| **Pull (풀)** | GitHub의 새 변경사항을 내 컴퓨터로 가져오는 것 |
| **Pull Request (PR)** | "내 브랜치를 main에 합쳐 주세요"라고 요청하는 것 |
| **Merge (머지)** | 두 브랜치의 내용을 합치는 것 |
| **Conflict (충돌)** | 두 사람이 같은 부분을 다르게 고쳐서 자동으로 합칠 수 없는 상태 |

---

## 2. 설치 및 로그인

1. [GitHub 계정](https://github.com/signup)을 만듭니다.
2. [GitHub Desktop](https://desktop.github.com/)을 설치합니다.
3. 실행 후 **Sign in to GitHub.com**을 눌러 로그인합니다.
4. 이름/이메일 설정 화면이 나오면 GitHub 계정과 같은 정보로 두고 **Finish**를 누릅니다.

> 리포지토리 관리자에게 GitHub 아이디를 알려주고 **Collaborator 초대**를 받아야 Push할 수 있습니다. 초대 메일(또는 GitHub 알림)에서 **Accept invitation**을 눌러 주세요.

---

## 3. 리포지토리 내려받기 (Clone)

처음 한 번만 하면 됩니다.

1. 상단 메뉴 **File → Clone repository...**
2. **GitHub.com** 탭에서 `JMRGconch/OOP2_YachtDice` 선택
   - 목록에 없으면 **URL** 탭에 `https://github.com/JMRGconch/OOP2_YachtDice.git` 입력
3. **Local path**에서 저장할 폴더를 확인하고 **Clone** 클릭

---

## 4. 내 브랜치 만들기

각자 **자기 이름의 브랜치**에서만 작업합니다. (예: `Choi_Goeun`)
**main 브랜치는 가급적 수정하지 말아주세요!**

1. 상단의 **Current branch** 버튼 클릭
2. **New branch** 클릭
3. 브랜치 이름 입력 (예: `Hong_Gildong`)
4. **Create branch based on...** 에서 **main**이 선택되어 있는지 확인 후 **Create branch**
5. 상단 버튼이 **Publish branch**로 바뀌면 클릭 → GitHub에 내 브랜치가 생성됩니다

> 작업 전에 항상 상단 **Current branch**가 **내 브랜치**인지 확인하세요!
>
> 다른 브랜치로 이동할 때는 **Current branch → 원하는 브랜치 클릭**하면 됩니다.

---

## 5. 작업 시작 전: Fetch origin / Pull origin

다른 사람이 올린 변경사항을 확인하고 가져오는 단계입니다.

1. 상단 오른쪽 **Fetch origin** 클릭 → GitHub에 새 변경사항이 있는지 확인
2. 새 변경사항이 있으면 버튼이 **Pull origin ↓**으로 바뀜 → 클릭해서 가져오기

> **Fetch**는 "확인만", **Pull**은 "실제로 가져오기"입니다.
> 내 브랜치의 Pull은 **내 브랜치의** 최신 내용만 가져옵니다. **main의 최신 내용**은 [8번 Update from main](#8-main의-최신-내용-가져오기-update-from-main)으로 가져옵니다.

---

## 6. 변경사항 저장하기: Commit

코드를 수정하면 GitHub Desktop 왼쪽 **Changes** 탭에 변경된 파일이 표시됩니다.

1. **Changes** 탭에서 커밋할 파일의 체크박스 확인 (체크된 파일만 커밋됨)
2. 파일을 클릭하면 오른쪽에서 변경 내용을 볼 수 있음
   - 🟩 초록색: 추가된 줄 / 🟥 빨간색: 삭제된 줄
3. 왼쪽 아래 **Summary**에 무엇을 했는지 짧게 작성 (필수)
   - 예: `주사위 굴리기 기능 추가`, `점수 계산 버그 수정`
4. **Description**에는 필요하면 자세한 설명 작성 (선택)
5. **Commit to [내 브랜치 이름]** 버튼 클릭

> 버튼에 `Commit to main`이라고 써 있으면 **멈추세요!** 브랜치를 내 브랜치로 바꾼 뒤 커밋해야 합니다.
>
> 방금 한 커밋이 잘못됐다면, Push 전이라면 왼쪽 아래의 **Undo** 버튼으로 취소할 수 있습니다.

---

## 7. GitHub에 올리기: Push origin

커밋은 아직 **내 컴퓨터에만** 저장된 상태입니다. GitHub에 올려야 팀원이 볼 수 있습니다.

1. 커밋 후 상단 버튼이 **Push origin ↑** 으로 바뀜 (숫자는 올릴 커밋 개수)
2. 클릭하면 GitHub의 내 브랜치에 업로드됩니다

> 작업을 마칠 때는 꼭 **Commit → Push**까지 해 주세요. 컴퓨터가 고장 나도 코드가 안전하게 보관됩니다.

---

## 8. main의 최신 내용 가져오기: Update from main

다른 팀원의 작업이 main에 합쳐지면, 내 브랜치에도 반영해야 합니다. **PR을 올리기 전과 작업 시작 전**에 해 주세요.

1. **Current branch**가 내 브랜치인지 확인
2. 상단 **Fetch origin** 클릭
3. 상단 메뉴 **Branch → Update from main** 클릭
4. 문제 없이 합쳐지면 **Push origin**으로 GitHub에도 반영

> 충돌(Conflict) 창이 뜨면 직접 해결하지 말고 **Abort merge**를 누른 뒤 main 브랜치 관리자에게 알려주세요.

---

## 9. 내 작업 합치기 요청: Pull Request

내 브랜치의 작업이 완성되면 main에 합쳐 달라고 요청합니다.

### Pull Request 올리기
1. 먼저 [8번 Update from main](#8-main의-최신-내용-가져오기-update-from-main)으로 최신 main을 반영하고, 프로그램이 정상 실행되는지 확인
2. 모든 변경사항을 **Commit → Push** 완료
3. 상단 메뉴 **Branch → Create Pull Request** 클릭 (또는 화면에 보이는 **Create Pull Request / Preview Pull Request** 버튼)
4. 웹 브라우저에서 GitHub 페이지가 열립니다
5. 위쪽이 `base: main` ← `compare: 내 브랜치`인지 확인
6. **제목**과 **설명**(무엇을 했는지, 테스트 방법 등) 작성
7. **Create pull request** 클릭

### Pull Request를 올린 후
1. Pull Request가 main에 합쳐지면 각자 **Update from main**으로 최신 상태를 받아옵니다

---

## 10. 하루 작업 흐름 요약

```
 ① GitHub Desktop 실행
 ② Current branch → 내 브랜치 선택
 ③ Fetch origin  →  Branch → Update from main
 ④ 코드 작업
 ⑤ Commit to [내 브랜치]   (자주 하는 것이 좋습니다)
 ⑥ Push origin
 ⑦ 기능 완성 시 → Update from main → Create Pull Request
```

---

## 11. 팀 규칙 & 자주 하는 실수

### 팀 규칙
- **main 브랜치에 직접 커밋/푸시하지 않기** — 모든 변경은 PR로
- 커밋 전 **Current branch가 내 브랜치인지** 확인하기
- 커밋은 **기능 단위로 작게, 자주** 하기
- 커밋 메시지는 **무엇을 했는지 알 수 있게** 쓰기 (`수정`, `ㅇㅇ` ❌)
- 작업 시작 전 **Update from main** 하기
- 같은 파일을 여러 명이 동시에 크게 고치지 않도록 미리 역할 분담하기
- IDE 설정 파일(`.metadata` 등)이나 빌드 결과물(`bin/` 등)은 가능하면 커밋하지 않기

### 자주 하는 실수
| 상황 | 해결 방법 |
|---|---|
| 실수로 main에서 코드를 수정함 (아직 커밋 전) | **Current branch → 내 브랜치** 선택 시 뜨는 창에서 **Bring my changes to [내 브랜치]** 선택 |
| 실수로 main에 커밋함 (아직 Push 전) | 왼쪽 아래 **Undo**로 커밋 취소 → 내 브랜치로 이동(위 방법) → 다시 커밋 |
| 브랜치를 바꾸려는데 경고 창이 뜸 | 수정 중인 파일이 있어서임. 먼저 커밋하거나, **Leave my changes on [현재 브랜치]**(임시 보관, Stash) 선택 |
| Push가 안 되고 `Pull origin`이 뜸 | GitHub에 내가 모르는 커밋이 있음. **Pull origin** 먼저 한 뒤 Push |
| 변경한 파일을 원래대로 되돌리고 싶음 (커밋 전) | Changes 탭에서 파일 우클릭 → **Discard changes** (되돌릴 수 없으니 주의!) |
| GitHub Desktop에서 파일을 바로 열고 싶음 | 상단 메뉴 **Repository → Show in Explorer** 또는 **Open in [에디터]** |