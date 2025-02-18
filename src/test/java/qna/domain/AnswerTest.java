package qna.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {
    public static final Answer A1 = new Answer(UserTest.DORAEMON, QuestionTest.Q1, "Answers Contents1");
    public static final Answer A2 = new Answer(UserTest.SPONGEBOB, QuestionTest.Q1, "Answers Contents2");

    @Test
    void deleteTest() {
        Answer answer = new Answer(
                7L,
                UserTest.DORAEMON,
                QuestionTest.Q1,
                "Answers Contents1");
        assertThat(answer.isDeleted()).isFalse();

        DeleteHistory history = answer.delete(UserTest.DORAEMON);
        assertThat(answer.isDeleted()).isTrue();
        assertThat(history.getContentType()).isEqualTo(ContentType.ANSWER);
        assertThat(history.getContentId()).isEqualTo(7L);
    }
}
