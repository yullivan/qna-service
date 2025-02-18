package qna.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionTest {
    public static final Question Q1 = new Question("title1", "contents1").writeBy(UserTest.DORAEMON);
    public static final Question Q2 = new Question("title2", "contents2").writeBy(UserTest.SPONGEBOB);

    @Test
    void deleteTest() {
        Question question = new Question(
                "Title",
                "Answers Contents1",
                UserTest.DORAEMON);
        assertThat(question.isDeleted()).isFalse();

        DeleteHistory history = question.deleteWithValidation(UserTest.DORAEMON);
        assertThat(question.isDeleted()).isTrue();
        assertThat(history.getContentType()).isEqualTo(ContentType.QUESTION);
        assertThat(history.getDeletedBy()).isEqualTo(UserTest.DORAEMON);
    }
}
