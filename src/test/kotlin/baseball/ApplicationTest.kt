package baseball

import nextstep.utils.Randoms
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import test.NSTest

class ApplicationTest : NSTest() {

    @BeforeEach
    fun beforeEach() {
        super.setUp()
    }

    @Test
    fun 낫싱() {
        Mockito.mockStatic(Randoms::class.java).use { mockRandoms ->
            mockRandoms
                .`when`<Any> {
                    Randoms.pickNumberInRange(
                        ArgumentMatchers.anyInt(),
                        ArgumentMatchers.anyInt()
                    )
                }
                .thenReturn(1, 3, 5)
            running("246")
            verify("낫싱")
        }
    }

    @Test
    fun 게임종료_후_재시작() {
        Mockito.mockStatic(Randoms::class.java).use { mockRandoms ->
            mockRandoms.`when`<Any> {
                Randoms.pickNumberInRange(
                    ArgumentMatchers.anyInt(),
                    ArgumentMatchers.anyInt()
                )
            }
                .thenReturn(7, 1, 3)
                .thenReturn(5, 8, 9)
            run("713", "1", "597", "589", "2")
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼")
        }
    }

    @AfterEach
    fun tearDown() {
        outputStandard()
    }

    override fun runMain() {
        Application1.main(arrayOf())
    }
}