package abc.core.subjectarea

import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RestAPI (var ip: String = "127.0.0.1", var port: Int = 4567){
    suspend fun setTakingForAll(SessionToken:String,takingId:Long) : JInt {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/rating/takingforall?takingId="+takingId+"",RequestInit("post",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JInt>(response)
        }
    suspend fun execTransition(SessionToken:String) : JEmpty {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/state/change",RequestInit("post",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
    suspend fun createGroupReportArtifact(SessionToken:String,ratingId:Long,filetype:Int) : Artifact {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/report/group/artifact?ratingId="+ratingId+"&filetype="+filetype+"",RequestInit("get",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<Artifact>(response)
        }
    suspend fun addGroupToDiscipline(SessionToken:String) : JLong {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/rating/group/add",RequestInit("post",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JLong>(response)
        }
    suspend fun getRatingsForGroup(SessionToken:String,ratingId:Long) : SAGroupRating {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/rating/group/get?ratingId="+ratingId+"",RequestInit("get",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<SAGroupRating>(response)
        }
    suspend fun createGroupReportTable(SessionToken:String,ratingId:Long) : TableData {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/report/group/table?ratingId="+ratingId+"",RequestInit("get",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<TableData>(response)
        }
    suspend fun getRatingsForTaking(SessionToken:String,takingId:Long) : SAExamTaking {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/rating/taking/get?takingId="+takingId+"",RequestInit("get",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<SAExamTaking>(response)
        }
    suspend fun removeGroupFromExam(SessionToken:String,ratingId:Long) : JEmpty {
        val response = window
        .fetch("http://"+ip+":"+port+"/api/rating/group/remove?ratingId="+ratingId+"",RequestInit("post",Headers().append("SessionToken",SessionToken)))
            .await().text().await()
        val format = Json { ignoreUnknownKeys = true }
        return format.decodeFromString<JEmpty>(response)
        }
}
