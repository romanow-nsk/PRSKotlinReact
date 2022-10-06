import abc.core.subjectarea.JInt
import abc.core.subjectarea.RestAPIBase
import abc.core.subjectarea.User
import kotlinx.browser.document
import kotlinx.browser.window
import react.create
import react.dom.client.createRoot
import kotlin.js.Json
import kotlinx.browser.window
import kotlinx.coroutines.*
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
    val user = api.login("9136666666","1234")
    token = user.sessionToken
    val list = api.getEntityList(token,"User",0,0)
    val welcome = Welcome.create {
        name = api.ip+" JInt="+user.sessionToken + list[0].jsonObject

        }
    createRoot(container).render(welcome)
}