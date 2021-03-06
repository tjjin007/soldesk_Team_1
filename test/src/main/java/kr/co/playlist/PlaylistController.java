package kr.co.playlist;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dao.MediaDAO;
import kr.co.dto.MediaDTO;
import kr.co.utility.Utility;

@Controller
public class PlaylistController {
	public static Logger logger = LoggerFactory.getLogger(PlaylistController.class);
	
	@Autowired
	MediaDAO mediaDAO;
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping("/playlist/toplist.do")												// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Toplist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/toplist");												// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		//bubbleChart를 보여주기위해  전체 노래 정보 조회
		List<MediaDTO> musicList= mediaDAO.list();										 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		 
		// dash board 부분 
		List<MediaDTO> topList= mediaDAO.toplist();										//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONArray jsonTopTen = Utility.getJsonTopMusic(topList);	 
		mav.addObject("jsonTopTen",jsonTopTen);											// DashBoard JsonObj
		mav.addObject("topList", topList);														// top 10 리스트 
		
		
		return mav;
	} // Toplist() end
	@RequestMapping(value="/playlist/toplistplay.do", method=RequestMethod.GET)
	public ModelAndView play(MediaDTO mediaDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/toplist");											// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		
		mediaDAO.playcnt(mediaDTO.getLyricsNo()); 									// 플레이 횟수 증가 
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		List<MediaDTO> topList=mediaDAO.toplist(); 
		mediaDTO = mediaDAO.read(mediaDTO.getLyricsNo());
		String url[]=mediaDTO.getUrl().split("=");
		mav.addObject("videoId", url[1]);
		mav.addObject("lyrics", mediaDTO.getLyrics());
		JSONArray jsonTopTen = Utility.getJsonTopMusic(topList);	 
		mav.addObject("jsonTopTen",jsonTopTen);											// DashBoard JsonObj
		mav.addObject("topList", topList);
		
		return mav;
	} // play() end
	
	@RequestMapping("/playlist/randomplaylist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Randomplaylist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/randomplaylist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		List<MediaDTO> randomList= mediaDAO.randomList();										//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		mav.addObject("randomList", randomList);														// Random 리스트 
		
		
		return mav;
	} // Randomplaylist() end
	
	@RequestMapping(value="/playlist/randomplay.do", method=RequestMethod.GET)								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Randomplay(MediaDTO paramMediaDTO) {
		ModelAndView mav = new ModelAndView();
		mediaDAO.playcnt(paramMediaDTO.getLyricsNo()); 									// 플레이 횟수 증가 
		MediaDTO mediaDTO = mediaDAO.read(paramMediaDTO.getLyricsNo());		// 해당 노래 조회
		mediaDTO.setEmotion(paramMediaDTO.getEmotion());						// 페이지에서 받은 감정 타입까지 저장 

		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		List<MediaDTO> randomList= mediaDAO.randomList();										//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		mediaDTO = mediaDAO.read(mediaDTO.getLyricsNo());
		String url[]=mediaDTO.getUrl().split("=");
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String userId = "Ciel Lu";
		String title = mediaDTO.getTitle();
		String emotion = mediaDTO.getEmotion();
		hashMap.put("userId", userId);
		hashMap.put("title", title);
		hashMap.put("emotion", emotion);
		//mediaDAO.dateinsert(hashMap);		// 혁준씨 추가 부분 -> 랜덤플레이 페이지에서 감정 분류 필요
		
		mav.setViewName("playlist/randomplaylist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		mav.addObject("jsonEmotion",jsonEmotion);
		mav.addObject("randomList", randomList);		// Random 리스트 
		mav.addObject("videoId", url[1]);
		mav.addObject("lyrics", mediaDTO.getLyrics());
		
		return mav;
	} // Randomplay() end
	
	@RequestMapping("/playlist/emotion.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotion() {
		ModelAndView mav = new ModelAndView();
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		String emotionTypeArray[] ={"happy","disgust","fear","interest","pain","rage","sad"};
		ArrayList<ArrayList<MediaDTO>> emotionMusicArrayList = Utility.getEmotionMusicList(musicList);
		mav.setViewName("playlist/emotion");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		mav.addObject("jsonEmotion",jsonEmotion);
		//mav.addObject("emotionMusicArrayList",emotionMusicArrayList);
		return mav;
	} // Emotion() end
}
