<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900italic,900' rel='stylesheet' type='text/css'>

<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch' href='http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
<link rel='stylesheet prefetch' href='css/nouislider.min.css'>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<section class="header">
		<!-- 왼쪽 상단 화살표 2개 -->
		<div class="page-flows">
			<span class="flow"><a href="../index.jsp"> <i class="ion-chevron-left"></i></a> </span>
			<span class="flow"> <i class="ion-chevron-right disabled"></i> </span>
		</div>
 		<!-- 
 		검색창
		<div class="search">
			<input type="text" placeholder="Search" />
		</div>
		 -->
		<!-- 로그인 시 회원 정보 -->
		<div class="user">
			<div class="user__notifications">
				<i class="ion-android-notifications"></i>
			</div>

			<div class="user__inbox">
				<i class="ion-archive"></i>
			</div>

			<div class="user__info">
				<span class="user__info__img">
					<img src="../image/adam_proPic.jpg" alt="Profile Picture" class="img-responsive" />
				</span>
				<span class="user__info__name">
					<span class="first">권</span>
					<span class="last">혁준</span>
				</span>
			</div>

			<div class="user__actions">
				<div class="dropdown">
					<button class="dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						<i class="ion-chevron-down"></i>
					</button>
					<ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
						<li><a href="../user/Private.jsp">개인 정보</a></li>
						<li><a href="../user/Customer.jsp">고객 센터</a></li>
						<li><a href="#">로그 아웃</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<!-- 본문 -->
	<section class="content">
		<!-- 왼쪽의 메뉴 부분 -->
		<div class="content__left">
			<section class="navigation">
				<!-- Main -->
				<div class="navigation__list">
					<div class="navigation__list__header" role="button" data-toggle="collapse" href="#main" aria-expanded="true" aria-controls="main">
						Main
					</div>

					<div class="collapse in" id="main">
						<a href="../main/Search.jsp" class="navigation__list__item">
							<i class="ion-ios-browsers"></i>
							<span>감성 검색</span>
						</a>
						<a href="../main/Share.jsp" class="navigation__list__item">
							<i class="ion-person-stalker"></i>
							<span>감정 공유</span>
						</a>
						
					</div>
				</div>
				<!-- / -->

				<!-- Your Music -->
				<div class="navigation__list">
					<div class="navigation__list__header" role="button" data-toggle="collapse" href="#yourMusic" aria-expanded="true" aria-controls="yourMusic">
						Your Music
					</div>

					<div class="collapse in" id="yourMusic">
						<a href="../music/Replay.jsp" class="navigation__list__item">
							<i class="ion-headphone"></i>
							<span>노래 다시듣기</span>
						</a>
						<a href="../music/Emotionlist.jsp" class="navigation__list__item">
							<i class="ion-ios-musical-notes"></i>
							<span>감정 그래프</span>
						</a>
					</div>
				</div>
				<!-- / -->

				<!-- Playlists -->
				<div class="navigation__list">
					<div class="navigation__list__header" role="button" data-toggle="collapse" href="#playlists" aria-expanded="true" aria-controls="playlists">
						Playlists
					</div>

					<div class="collapse in" id="playlists">
						<a href="../playlist/Toplist.jsp" class="navigation__list__item">
							<i class="ion-ios-musical-notes"></i>
							<span>TOP 100</span>
						</a>
						<a href="../playlist/Emotion.jsp" class="navigation__list__item">
							<i class="ion-ios-musical-notes"></i>
							<span>감성 보기</span>
						</a>
						<a href="../playlist/Randomplay.jsp" class="navigation__list__item">
							<i class="ion-ios-musical-notes"></i>
							<span>랜덤 듣기</span>
						</a>
				
					</div>
				</div>
				<!-- / -->
			</section>

		</div>

		<!-- 메인에 해당하는 부분 -->
		<div class="content__middle">
		