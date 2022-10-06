package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class ConstValue(var groupName:String?="", var name:String?="", var title:String?="...", var className:String?="", var value:Int=0) { }