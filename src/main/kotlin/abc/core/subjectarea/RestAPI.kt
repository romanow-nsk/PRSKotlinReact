package abc.core.subjectarea

import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RestAPI (var ip: String = "127.0.0.1", var port: Int = 4567){
    suspend fun execTransition(SessionToken:String) : Pair<String?,JEmpty?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/state/change",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<JEmpty>(res2))
    }
    suspend fun setTakingForAll(SessionToken:String,takingId:Long) : Pair<String?,JInt?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/rating/takingforall?takingId="+takingId+"",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<JInt>(res2))
    }
    suspend fun removeGroupFromExam(SessionToken:String,ratingId:Long) : Pair<String?,JEmpty?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/rating/group/remove?ratingId="+ratingId+"",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<JEmpty>(res2))
    }
    suspend fun getRatingsForTaking(SessionToken:String,takingId:Long) : Pair<String?,SAExamTaking?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/rating/taking/get?takingId="+takingId+"",RequestInit("get",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<SAExamTaking>(res2))
    }
    suspend fun addGroupToDiscipline(SessionToken:String) : Pair<String?,JLong?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/rating/group/add",RequestInit("post",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<JLong>(res2))
    }
    suspend fun getRatingsForGroup(SessionToken:String,ratingId:Long) : Pair<String?,SAGroupRating?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/rating/group/get?ratingId="+ratingId+"",RequestInit("get",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<SAGroupRating>(res2))
    }
    suspend fun createGroupReportArtifact(SessionToken:String,ratingId:Long,filetype:Int) : Pair<String?,Artifact?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/report/group/artifact?ratingId="+ratingId+"&filetype="+filetype+"",RequestInit("get",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<Artifact>(res2))
    }
    suspend fun createGroupReportTable(SessionToken:String,ratingId:Long) : Pair<String?,TableData?> {
        val headers = Headers()
        headers.append("SessionToken",SessionToken)
        val res = window
        .fetch("http://"+ip+":"+port+"/api/report/group/table?ratingId="+ratingId+"",RequestInit("get",headers))
            .await()
        if (!res.ok)
            return Pair(res.statusText+" "+res.text().await(),null)
        val res2 = res.text().await()
        val format = Json { ignoreUnknownKeys = true }
        return Pair(null,format.decodeFromString<TableData>(res2))
    }
}
