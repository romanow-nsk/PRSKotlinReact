package abc.core.subjectarea
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class EntityLink<T : Entity?> {
    var oid: Long = 0L
    var ref: T? = null
}
