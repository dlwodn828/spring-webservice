package com.jaewoo.springwebservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 생성하는 것은 허
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 자동 추가, 접근 권한 protected
@Getter
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts {
    @Id
    @GeneratedValue
    private Long id; //PK

    @Column(length = 500, nullable = false) // 기본 속성을 변경하고 싶을 때만 사
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    setter가 없는데 어떻게 값을 집어 넣는가?
    - 최종 값을 생성자를 통해 Insert하도록하고 변경이 필욯나 경우는 해당 이벤트에 맞는 public
    메소드를 호출하여 변경

    생성자 vs 빌더
    - 생성자는 파라미터 순서가 중요한데 개발자가 인지하기 쉽지 않다. 반면 빌더는 직관적으로
    보이기 때문에 논리 오류가 안 생긴다.
     */
    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content = content;
        this.author = author;
    }
}
