<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jqcloud/1.0.4/jqcloud.css" rel="stylesheet"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqcloud/1.0.4/jqcloud-1.0.4.js"></script>
    
<!-- 타이틀 -->
	<div class="head_tit">
		<h3>로그인</h3>
		<ul class="navy">
			<li class="home"><img src="../../images/ico_head_title_home.png"
				alt="홈" /></li>
			<li>계정관리</li>
			<li>로그인</li>
		</ul>
	</div>

	<!-- 로그인 -->
		<div class="loginTop">
			<div id="jqcloud"></div>
		</div>

	


	<!-- //로그인 -->
		<script>
//     const keyword = ['foo','bar', 'baz'].map(keyword => ({
// 	  text: keyword,
// 	  handlers: {
// 	    click: () => {
// 	      alert('you clicked on "' + keyword + '"');
// 	    }
// 	  }
// 	}));
    var keyword = [
     {text: "Lorem", weight: 15},
     {text: "Ipsum", weight: 9, link: "http://jquery.com/"},
     {text: "Dolor", weight: 6, html: {title: "I can haz any html attribute"}},
     {text: "Sit", weight: 7},
     {text: "Amet", weight: 5}
     // ...as many words as you want
 ];
	$(function() {
		var tags = [
		    "Delegation", "Composition", "Aggregation","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java","Java", "Design Pattern", "Lazy-Initialization", "JCF", "HashSet", "TreeSet", "LinkedHashSet", "Map", "IdentityHashMap", "List", "ArrayList", "Design-Pattern", "Singleton", "MultiThreading", "Template-pattern", "Set", "Ordering", "LinkedList", "Java-puzzle", "Visitor", "PathMatcher", "thread", "exception-handling", "kill-thread", "FP", "Functional-programming", "Scala", "Algorithm", "convert-array-dimension", "toString", "Closure", "Currying", "JavaScript", "RegEx", "숫자,영문,한글 입력 제한", "Literal", "Multi-threads", "Constructor", "Generics", "Lower-bound", "Upper-bound", "ReactiveX", "Mixin", "Case Class",  "singleton", "companion", "스칼라", "함수형언어", "Docker", "homebrew", "Spring", "Spring-boot", "fork-join", "Git", "branching", "브랜칭",  "logstash", "kibana", "로그스테쉬", "엘라스틱서치", "키바나", "Pro-git", "Jekyll", "tag-search", "카테고리검색", "태그검색", "카테고리검색", "태그검색", "카테고리검색", "태그검색", "카테고리검색", "태그검색", "카테고리검색", "태그검색", "tag-cloud", "Angular4", "Data binding", "Directive", "Axon", "CQRS",  "Secure Coding", "recruit", "ripple", "리플", "번역", "Toss", "OAuth2", "ESLint", "Tomcat", "JNDI"
		  ]

		  var words = [];
		  tags.forEach(t => {
		    var key = t;
		    if (words[key]) {
		      words[key] = words[key] + 1;
		    } else {
		      words[key] = 1;
		    }
		  });
		  var tagCloudWords = Object.keys(words).map(w => {
		    return {
		      text: w, weight: words[w], link: '/search/?tag=' + w
		    };
		  });
		  $('#jqcloud').jQCloud(tagCloudWords,
		    {
		      height: 400,
		      autoResize: true,
// 		      fontSize: { from: 0.1, to: 0.01 }
		    }
		  );
	 });



	</script>