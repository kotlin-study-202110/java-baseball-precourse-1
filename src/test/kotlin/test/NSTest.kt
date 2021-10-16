package test

import org.assertj.core.api.Assertions
import org.assertj.core.util.Strings
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

abstract class NSTest {
    private var standardOut: PrintStream? = null
    private var captor: OutputStream? = null
    protected fun setUp() {
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    /**
     * 사용자의 입력을 기다리는 상황에서 테스트 종료
     * @param args
     */
    protected fun running(vararg args: String?) {
        Assertions.assertThatExceptionOfType(NoSuchElementException::class.java).isThrownBy {
            subject(*args as Array<out String>)
        }
    }

    /**
     * 프로그램이 정상적으로 종료
     * @param args
     */
    protected fun run(vararg args: String?) {
        subject(*args as Array<out String>)
    }

    protected fun verify(vararg args: String?) {
        Assertions.assertThat(output()).contains(*args)
    }

    private fun subject(vararg args: String) {
        command(*args)
        runMain()
    }

    abstract fun runMain()
    private fun command(vararg args: String) {
        val buf = Strings.join(*args).with("\n").toByteArray()
        System.setIn(ByteArrayInputStream(buf))
    }

    protected fun output(): String {
        return captor.toString().trim { it <= ' ' }
    }

    protected fun outputStandard() {
        System.setOut(standardOut)
        println(output())
    }
}
