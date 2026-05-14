package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.answer.Answer;
// import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	// @Autowired
	// private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네. 자동으로 생성됩니다.", answerList.get(0).getContent());
	}


	/*
    @Test
	void testJpa(){ //답변 조회
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
	}

	/*
	@Test
	void testJpa(){ //답변 추가
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네. 자동으로 생성됩니다.");
		a.setQuestion(q); //어떤 질문의 답변인지 알기 위해 question객체를 이용(id를 받아온다)
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}

	/*
	@Test
	void testJpa() { //데이터 삭제하기
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}

	/*
	@Test
	void testJpa() { //데이터 수정하기
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}

	/*
	@Test
	void testJpa() {//Question리포에서 선언한 메서드 활용2
		List<Question> qList = this.questionRepository.findBySubjectLike("demo%");
		Question q = qList.get(0);
		assertEquals("demo가 데모랑 같은 건가요?", q.getSubject());
	}

	/*
	@Test
	void testJpa(){ //Question리포에서 선언한 메서드 활용
		Question q = this.questionRepository.findBySubject("demo가 데모랑 같은 건가요?");
		assertEquals(1, q.getId());

		Question q2 = this.questionRepository.findBySubjectAndContent("demo가 데모랑 같은 건가요?", "demo가 무엇의 약자인지 알고 싶습니다.");
		assertEquals(1, q2.getId());
	}

	/*
	@Test
	void testJpa() { //테이블에 저장된 값을 id를 이용해 조회/비교하는 테스트
		Optional<Question> oq = this.questionRepository.findById(1);
		//findById로 호출한 값이 존재할 수도 있고, 존재하지 않을 수도 있어서 리턴 타입으로 Optional을 사용

		if(oq.isPresent()){
			Question q = oq.get();
			assertEquals("demo가 데모랑 같은 건가요?", q.getSubject());
		}
	}
	
	/*
	@Test
	void testJpa() { //테이블의 저장된 값이 코드와 동일한지 테스트
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("demo가 데모랑 같은 건가요?", q.getSubject());
	}

	/* 
	@Test
	void testJpa() { //테이블에 값을 집어넣는 코드(겸 테스트)
		Question q1 = new Question();
		q1.setSubject("demo가 데모랑 같은 건가요?");
		q1.setContent("demo가 무엇의 약자인지 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
	*/
}
