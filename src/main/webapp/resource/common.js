function SideBar__init(){
	$('.side-bar-btn').click(function(){
		$('.side-bar').addClass('active');
	});
	$('.side-bar__close-btn').click(function(){
		$('.side-bar').removeClass('active');
	});	
}

SideBar__init();