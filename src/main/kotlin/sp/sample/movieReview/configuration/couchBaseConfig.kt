package sp.sample.movieReview.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories
import sp.sample.movieReview.repository.MovieRepository
import sp.sample.movieReview.repository.ReviewRepository

@Configuration
@EnableReactiveCouchbaseRepositories(basePackageClasses = [MovieRepository::class, ReviewRepository::class])
class couchBaseConfig : AbstractCouchbaseConfiguration() {

    @Value("\${couchbase.hostname}")
    lateinit var connection: String

    @Value("\${couchbase.username}")
    lateinit var username: String

    @Value("\${couchbase.password}")
    lateinit var bucketPassword: String

    @Value("\${couchbase.bucketname}")
    lateinit var bucketname: String

    override fun getConnectionString(): String {
        return connection
    }

    override fun getUserName(): String {
        return username
    }

    override fun getPassword(): String {
        return bucketPassword
    }

    override fun getBucketName(): String {
        return bucketname
    }
}
