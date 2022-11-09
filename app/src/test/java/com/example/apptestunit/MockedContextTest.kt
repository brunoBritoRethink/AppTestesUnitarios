import android.content.Context
import androidx.core.app.Person
import com.example.apptestunit.ContextWrapper
import com.example.apptestunit.PersonModel
import com.example.apptestunit.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

private val FAKE_PERSON = PersonModel("", "")

@RunWith(MockitoJUnitRunner::class)
class MockedContextTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        val person = PersonModel("Bruno", "23")
        val mockContext = mock<Context> {
            on { person } doReturn(FAKE_PERSON)
        }

        val myObjectUnderTest = ContextWrapper(mockContext)

        // ...when the string is returned from the object under test...
        val result: PersonModel = myObjectUnderTest.getTitle()

        // ...then the result should be the expected one.
        assertEquals(result, FAKE_PERSON)
    }
}