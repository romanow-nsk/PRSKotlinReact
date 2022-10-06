import abc.core.subjectarea.RestAPIBase
import abc.core.subjectarea.User
import kotlinx.browser.document
import kotlinx.browser.window
import react.create
import react.dom.client.createRoot
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit


/** Активность клиента - в ответе - количество неподтвержденных уведомлений  */
//@GET("/api/keepalive")
//fun keepalive(@Header("SessionToken") token: String?): Call<JInt?>?

suspend fun keepAlive2(token:String): String {
    val response = window
        .fetch("http://localhost:4567/api/keepalive", RequestInit("get",Headers().append("SessionToken",token)))
        .await()
        .text()
        .await()
    return response
    }
var token:String=""
suspend fun main(args: Array<String>) {
    val container = document.createElement("div")
    document.body!!.appendChild(container)
    val api:RestAPIBase  = RestAPIBase()
    val ss = api.keepalive("1111111")
    val userPair = api.login("9136666666","1234")
    var out = ""
    if (!userPair.valid())
        out = userPair.mes
    else {
        token = userPair.data!!.sessionToken
        val list = api.getEntityList(token,"User",0,0)
        val format = Json { ignoreUnknownKeys = true }
        for (vv in list.data!!){
            var user2 = format.decodeFromString<User>(vv.jsonObject)
            out += user2.lastName+"_"+user2.firstName+" "
            }
        }
    val welcome = Welcome.create {
        name = api.ip+" "+token+" "+out

        }
    createRoot(container).render(welcome)
}