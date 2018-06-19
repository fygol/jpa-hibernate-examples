package io.examples.hibernate.one_to_one;

import io.examples.hibernate.AbstractTest;
import org.junit.Test;

public class OneToOneTest extends AbstractTest {
    @Test
    public void testSave() {
        transaction(em -> {
            Post post = new Post();
            post.setTitle("Post 1");

            PostDetails postDetails = new PostDetails("User 1");
            post.setDetails(postDetails);

            em.persist(post);
        });

        transaction(em -> {
            em.createQuery("select pd from PostDetails pd where pd.post.id = :postId", PostDetails.class)
                    .setParameter("postId", 1L)
                    .getResultList();
        });
    }
}
