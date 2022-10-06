package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class R<T>(var mes:String="",var data:T?=null) {
fun valid():Boolean { return mes.length==0 }}