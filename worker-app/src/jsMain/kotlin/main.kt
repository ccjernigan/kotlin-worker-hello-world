import org.w3c.fetch.Request
import org.w3c.fetch.Response
import org.w3c.fetch.ResponseInit
import kotlin.js.Promise

internal fun application(@Suppress("UNUSED_PARAMETER") request: Request) = Promise<Response> { resolve, reject ->
    runCatching {
        val headers: dynamic = object {}
        headers["content-type"] = "text/plain"
        resolve(Response("Hello world", ResponseInit(headers = headers)))
    }.onFailure {
        reject(RuntimeException("Failed to respond"))
    }
}
