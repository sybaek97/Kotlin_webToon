## 개요

- 버튼을 누르면 숫자가 1씩 올라감
- 초기화 기능이 잇음
- 9999까지 숫자를 셀 수 있음

## 구현기능

- +버튼을 클릭 시, 숫자 1씩 올라감
- 초기화 버튼 클릭 시, 숫자를 0으로 변경가능

## 추가 구현 기능

- -버튼을 만들고 0 이하로는 절대 안내려가게 함
- 마찬가지로 max범위를 10이하로 설정하여 클릭했을 시 더 안올라가게함
- 화면을 돌렸을때 비율을 유지하도록 구현

## 목표

- LinearLayout을 이용해 간단한 ui 그리기
- Acitivity를 통해 사용자 입력에 대한 출력 보기

## 사용 기능

- UI
    - LinearLayout
        - 선형 도화지
    - TextView
    - Buton
- Kotlin
    - val, var
    - null
    - 복합대입 연산자
- Android
    - Activity
        - 화면이 전환되어도 값이 유지되도록 가능하게 해야되며 ui를 반영할수 있도록 하자
    - R 파일
        - 
    - findViewByld
    - setOnClickListener
    - log
        - LOG를 확인하는것이 중간중간 체크하기 위해 습관화 하는게 좋다
        

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/58253e7a-d1fb-40e0-a742-d5a1bc9ef061/1cf5dae7-fc60-46ea-84a7-150e5bea0be8/Untitled.png)

## 복습내용

- 이번 강의를 통해 기본적인 linearLayout을 알게 되었고 화면을 돌려도 비율이 유지되게 할 수 있는 선형구조를 갖는다는 것을 알게 되었습니다. 즉 유저의 편의성에 한 단계 다가 갈 수 있는 계기가 되었습니다.
