package sp.mycustom.reviewservice.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories
import sp.mycustom.reviewservice.repository.MovieRepository
import sp.mycustom.reviewservice.repository.ReviewRepository


@Configuration
@EnableReactiveCouchbaseRepositories(basePackageClasses = [MovieRepository::class,ReviewRepository::class])
class couchBaseConfig : AbstractCouchbaseConfiguration(){
    override fun getConnectionString(): String {
        return "localhost"
    }

    override fun getUserName(): String {
       return "Administrator"
    }

    override fun getPassword(): String {
        return "Somanchi@98"
    }

    override fun getBucketName(): String {
        return "default"
    }

}