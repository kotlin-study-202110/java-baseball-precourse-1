package baseball

import io.mockk.every
import io.mockk.mockkStatic
import nextstep.test.NSTest
import nextstep.utils.Randoms
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyInt
import util.StrikeMatcher

internal class KotlinApplicationKtTest: NSTest() {

    @BeforeEach
    fun beforeEach(){
        super.setUp()
    }

    @Test
    fun `List Contain 테스트`() {
        val collect = 123.split()
        val target = 321.split()

        val strike = StrikeMatcher()
        println(strike.match(collect, target))

        println(collect.containsAll(target))
    }

    @Test
    fun `Int split 테스트`(){
        val list = Randoms.pickNumberInRange(100, 999).split()

        list.forEach {
            assert(it.value!! < 10)
        }
    }

    @Test
    fun `낫싱`() {
       try{
           // given
           val mockRandoms = mockkStatic(Randoms::class)
           println(Randoms.pickNumberInRange(anyInt(), anyInt()))
           every { Randoms.pickNumberInRange(anyInt(), anyInt()) } returnsMany listOf(1,3,5)
           // when
           running("246")
           // verify
           io.mockk.verify { verify("낫싱") }

       }catch (e: Exception){
           println("낫싱에서 에러발생 ${e.message}")
       }
    }

    @Test
    fun `게임종료_후_재시작`() {
        try{
            // given
            val mockRandoms = mockkStatic(Randoms::class)
            println(Randoms.pickNumberInRange(anyInt(), anyInt()))
            every { Randoms.pickNumberInRange(1, 9) } returnsMany listOf(7,1,3)
            every { Randoms.pickNumberInRange(1, 9) } returnsMany listOf(5,8,9)
            // when
            run("713", "1", "597", "589", "2")
            // verify
            io.mockk.verify { verify("3스트라이크", "게임 끝", "1스트라이크 1볼") }

        }catch (e: Exception){
            println("게임종료_후_재시작에서 에러발생 ${e.message}")
        }
        }

    @AfterEach
    fun afterEach(){
        super.outputStandard()
    }

    override fun runMain() {
        //KotlinApplication().main()
    }
}