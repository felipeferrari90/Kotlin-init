//FUNCAO MAIN
fun main1(){

    //VARIAVEIS
    var nome1:String = "mutavel"
    val nome2:String = "imutavel"

    //CONSOLE
    print("valores: ${nome1} e ${nome2}"); //nao tem printf

    //CHAMADA FUNCAO
    var resultado:Int = somaUmaLinha(6,8);
}

fun soma(a:Int , b:Int):Int{
    return a + b;
}
fun somaUmaLinha(a:Int, b:Int):Int = a + b;

fun main2(){

    //NULLABLES
    //são tipos de variaveis que podem receber valores nulos

         //operador ?

         var variavelnula1:String = null;       //erro, valor por padrão nao pode ser nulo
         var variavelnula2:String? = null;      //operador ? permite valor receber parametro null

         //operador !!

         var tamanho1:Int = variavelnula2.length      //nao é possivel acessar propriedades de nulos
         tamanho1 = variavelnula2?.length             //nao compila pois nao da pra converter int? para int
         var tamanho2:Int? = variavelnula2?.length    //operador ? para acessar propriedades de nullables
         tamanho1 = variavelnula2!!.length            //o operador !! forca a conversao (não é recomendado)

         //os operadores ignoram nullables evitando erros de nullpointerException;
}

fun main3(args:List<String>){

    //ARRAYS
    val array1  = arrayOf(0,2,4,6,8)
    val indice1:Int = array1[2];

         //arrays dinamicos (Mutable List)
         val lista1 = listOf(1,3,5,7,9);
         val lista2 = mutableListOf(3,15,7,6,3);
         lista1.add(11);   //erro
         lista2.add(12);P

         //por padrao listas sao imutaveis (arrayof e listof)
         //MutableList é uma Interface

    /*** FOREACH
     - é uma funcao lambda de uma forma que podemos fazer um foreach sendo IT
     uma variavel de iteracao criada automaticamente */

    lista1.forEach {
        print("$it");
    }

    /*** FILTER
    - funcao que filtra uma lista a partir de um bloco de expressao true or false
    que pode retornar uma nova lista com todas as iteracoes que retornaram true*/

    val listaMultiplode3 = lista2.filter {
        it % 3 == 0
    }   // listaMultiplode3 = [3,15,6,3]

    /*** MAP
   - funcao que mapeia todos os elementos da lista retornando uma acao feita
     no bloco*/

    val listaQuadruplicada = lista1.map {
        it * 4
    }   // listaQuadruplicada = [0,8,16,24,32]
}

/**********************************************************************************************************************/


//CLASSE
class Moto{ }                    //declaracao normal

class Carro{                     //declaracao com atributos
    var nome:String = " ";       //porem pelos atributos serem var, eles podem ser mudados
    var ano:String = " ";
}
class Onibus(val nome:String, var ano:Int){ }  //declarando val no construtor, somente podendo ser configurado
                                               // uma unica vez sem precisar mudar
//CONSTRUTOR
class Caminhao constructor() {
    var modelo:String = ""                  //quando se tem 2 ou + construtores vc tem que ter um primario
    constructor(modelo:String):this(){      //e os secundarios chamarem ele atraves desse primario através
        this.modelo = modelo                //do this, os atributos precisam ser inicializadas
    }
}

fun main4(){
    val moto1:Moto = Moto();

    val carro1:Carro = Carro();
    carro1.nome = "opala";

    val onibus1:Onibus = Onibus("volvo",2012)
    print(onibus1.nome)   //imprime volvo

    val caminhao1:Caminhao = Caminhao()
    val caminhao2 = Caminhao("volvo");  //chamada de construtor secundario

}

/**********************************************************************************************************************/

//GETTERS E SETTERS

//get e set existem por padrao(Humano1) mas por alguma necessidade vc pode sobrescrevelos

class Humano{ var idade:Int = 26 }   //VAR - propriedade com getter e setter, VAL - apenas getter embutido
class Computador{

    val custo:Double = 10000.5
    val nome:String = "dell"
    var alteracoesDeCor:Int = 0

    val eCaro:Boolean                  //vc pode sobrescrever o GET() de uma propriedade pra inicializar um valor
        get() = custo > 5000           //nesse caso a variavel inicializaria como TRUE

    var cor:String = ""            // a variavel string se nao sofresse um set iniciaria "" para
        set(value){                // que ela nao se inicie nula
            field = value
            print("cor alterada")
            alteracoesDeCor++           //SET() sobrescrivido para atualizar o numero de alteracoes de cor que um
        }                               //objeto teve
}

fun main5(){
    var human:Humano = Humano();
    //****var getado:Int  = human.getIdade();  //nao se chama assim o getter nem o setter
    var getado2:Int = human.idade;             // nessa hora que o get() é chamado implicitamente
    var pc1:Computador = Computador();
    print(pc1.cor)                             //imprimira nao informado
    pc1.cor = "amarelo"
    print(pc1.alteracoesDeCor)                 //imprimira 1
}

/**********************************************************************************************************************/

// HERANÇA

open class Felino{            //OPEN - informa a classe pai
    fun arranhar(){}
    fun pular(){}
}
class gato:Felino(){            // metodo de herança, que atraves do construtor felino
    fun miar(){}                // gato possui os três metodos.
}

open class Aracnideo( val nome:String)
class Aranha( nome:String, val patas:Int):Aracnideo(nome)     //declacao de heranca feita por construtor com param

open class Operacao
class Mais:Operacao()
class Menos:Operacao()

fun retornarSinal():Operacao{
    if(nextBoolean()){                //nextBoolean() é da classe ramdom e retorna aleatoriamente um true or false
        return Mais()
    }else{
        return Menos()                //sim,essa fun te retorna um construtor de uma classe
    }
}
fun main6(){
    val operacaoAtual = retornarSinal()             //vc pode atribuir uma classe a uma variavel
    when(operacaoAtual){
        is Mais ->{
            println("é um objeto de tipo Mais")                   //when = switch em java sem precisar do break
        }        //is é igual ao instanceof do java
        is Menos ->{                                               // is = instanceof em java
            println("é um objeto de tipo Menos")
        }
    }
}

/**********************************************************************************************************************/

//INTERFACE

interface Clicavel{
    fun onClick()
}
class Botao:Clicavel{
    override fun onClick(){}           //override - pra indicar que o metodo esta sendo sobrescrito
}

val clique = object : Clicavel{      //vc pode atribuir uma implementacao de uma interface a uma variavel
    override fun onClick(){
        print("clicou")
    }
}

fun main7(){
    var tecla = clique;
    tecla.onClick();                // no visor imprime clicou
}

/**********************************************************************************************************************/

//DATA CLASS - usada para criar classes simples com apenas dados sem funs (com excecao das defauts( equals, hashcode...)

data class User(val name:String, val age: Int)

//ENUM CLASS - igual o enum do Java
enum class ClasseSocial { BAIXA, MEDIA, ALTA }

//SEALED CLASS - as classes seladas, são classes que só podem ser herdadas pelo mesmo escopo como se fosse uma subclasse
sealed class Status {
    class Loading : Status()
    class Success : Status()
    class Error : Status()
}

//OBJECT - Os objects, diferentes de classes , não possuem instancia. é um objeto estático.
object Servidor{
    fun ligarServidor(){}
}

fun main8(){
    val state: Status = Status.Loading()          //.Loading(). é a subclasse acessando a classe Sealed Status
    when(state){
        is Status.Loading->{ println("carregando") }
        is Status.Success->{ println( "sucesso") }    //printa carregando
        is Status.Error->{  println( "erro")  }
    }

    val cidadao = ClasseSocial.ALTA;     //exemplo com ENUM
    Servidor.ligarServidor()     // acessando staticamente classe por ela ter sido declarada como object
}

/**********************************************************************************************************************/

//FUNÇOES DE EXTENSÃO

  // é um recurso que permite vc extender as funcoes de uma classe sem poder mexer no escopo dela

class Cachorro(var latido:String){  fun latir(): String { return this.latido } }
fun Cachorro.latidoDuplo(): String { return this.latido + this.latido }

//agora todas os objetos da classe Cachorro terao a funcao latidoDuplo;

fun main9(){
    val cachorro = Cachorro( "au")
    val variavel1 = cachorro.latir()
    val variavel2 = cachorro.latidoDuplo()
}

/**********************************************************************************************************************/

// HIGH-ORDER FUNCTIONS

  //funcoes de alta ordem sção funcoes que recebem outras funcoes como args ou retornar funs ou fazer ambos

// FUNCOES DE CALLBACKS - é o exemplo mais pratico de onde se aplica mais high-order funs
//                        ela é uma funcao que é chamada logo após o retorno de uma funcao principal

fun executarRequisicao(){     /* conectando a API WEB */ }
var resposta1 = executarRequisicao()  // nao teriamos controle quando a resposta chegar mas alguma acao precisa ser feita
fun executarRequisicao(callback: ()-> Unit){  //entao pra isso preparamos a fun pra receber um callback
    //executar a chamada dessa fun...
    callback.invoke()
}

/*
Podemos criar uma variável que guarda a referência deuma função e passa-la por parâmetro. Esse recurso é
chamado de first class function, ou seja a linguagemtrata funções com o mesmo peso de variáveis.
*/

val callback: ()->Unit = {
    println("funcão de callback")
}
val resposta2 = executarRequisicao(callback)

/*
Uma outra forma é ter uma função realmente e passar sua referência por parâmetro:
 */

fun callback(){
    println("funcão de callback")
}
fun main10(){
    val resposta3 = executarRequisicao(::callback)

    /* Uma terceira forma de se passar a função é em forma de DSL. Se uma função recebe como último parâmetro uma
            outra função, podemos fazer a chamada dessa forma:*/

    val resposta = executarRequisicao(){
        println("funcão de callback")
    }


}

/**********************************************************************************************************************/

//INFIX FUNCTION

//Infix é a capacidade de invocar uma função de uma classe uma função de extensão sem a necessidade de
//utilizar o “.”

fun Int.somar(n:Int): Int {    //exemplo de funcao de extensao normal
    return this * n
}
/*
Poderiamos marcar a função multiplicar como infix e então sua chamada ficaria assim
*/

infix fun Int.multiplicar(n:Int): Int {
    return this * n
}


fun main11(){
    val resultado = 20.somar(4)
    println("$resultado")  //irá printar: 24

    val resultado = 20 multiplicar 4
    println("$resultado")  //irá printar: 80
}

//OBS: funcoes de infix só podem ser de extensao e so podem receber 1 parametro

/**********************************************************************************************************************/

//ARGUMENTOS DE FUNCOES - são valores fornecidos na chamada de uma função.

  val arg1 = 10;
  val arg2 = 20;     // no metodo main se chamaria ela assim:  somando(arg1,arg2)

//PARAMETROS DE FUNCOES -  são variáveis nomeadas dentro da função que recebem os valores fornecidos pelos args

  fun somando(arg1:Int, arg2:Int): Int = arg1 + arg2

//ARGUMENTOS NOMEADOS - vc pode passar diretamente o valor da variavel atribuida a variavel de escopo da msm funcao

fun main12(){
    somando(arg1 = 15, arg2 = 25)
}

//PARAMETROS OPCIONAIS - atribuindo um valor de args no escopo da fun faz esse param ser opcional

fun multiplicando(number1:Int, number2:Int = 1): Int{     //metodo main: multiplicando(5)  - console:5
    return number1 * number2
}

/**********************************************************************************************************************/

//FUNCOES DA STANDARD LIBRARY (STDLIB)

 /** LET
  *
  *  é simplesmente uma funcao de escopo (ou  seja, pode ser aplicada em qualquer tipo kotlin)
  *
  **/

fun main13(){

     val nome1 = "Felipe"
     nome1.let{
         print("$it")          //o let abre um escopo fechado para se trabalhar com algum valor usando it
     }

     val nome2:String? = "Vitor"     // para nullables tem que se atribuir o tipo antes obrigatoriamente (string?)
     nome2.let{
         print("$it")                //no exemplo anterior nao se via ultilidade para o let nesse ja tem
     }                               //que nesse caso seria acessar um valor que pode ser nulo.

 }

/** APPLY
 *
 *  é quase igual o LET mas o APPLY se usa para mudar valores de um objeto
 *
 **/

class Pessoa1{
    var nome:String = ""
    var sobreNome:String = ""
}

fun main14(){


    val p = Pessoa1().apply {
        this.nome = "Felipe"
        this.sobreNome = "Ferreira"
    }

}

/** ALSO
 *
 *  também muito parecido com o LET porem o let retorna valor, also nao retorna nada.
 *
 **/

fun somatoria(number1:Int, number2:Int): Int{
    return (number1 + number2).also {
        println("valores foram somados...")             // it = number1 + number2
    }
}

/**********************************************************************************************************************/

// NULLABLES TYPES

/*
*  por default nenhuma variável pode ser nula. No entanto, podemos habilitar que a variável pode receber valores nulos.
* acrecentando o operador “?” na frente do tipo da variável. Ex:
*
        var nome:String? = null
        var soma:Int? = null
        var resultado:Double? = null

    quando temos uma var nullable assumimos o risco de ela ter valor ou nao, certos cuidados tem que ser tomados:
*
* */
fun getIdade() = 26

fun main15() {

    val idade: Int? = getIdade()
    if (idade > 18) {                      //erro de compilacao : o operador > nao serve para comparar um nullable
        println("Maior de Idade")
    } else {
        println("Menor de idade")
    }

    /* exemplo com if para tratar com checagem de nullables */
    if(idade != null) {
        if (idade > 18) {
            println("Maior de Idade")      //forma de tratar caso idade nao fosse nula
        } else {
            println("Menor de idade")
        }
    }

    /* usando o LET */
    idade?.let {
        if (it > 18) {                      //ecomomia de if-else usando a funcao de escopo let
            println("Maior de Idade")
        } else {
            println("Menor de idade")
        }
    }

}

//var e nullables

/*  no exemplo anterior se usava val, porem com var os cuidados sao ainda maiores */

data class Pessoa3(val nome:String, var idade:Int?)
fun main() {
    val pessoa = Pessoa3("p1", 0)
    if(pessoa.idade != null){
        pessoa.idade += 10                 //ERRO : o compilador nao pode garantir que o var vai manter seu valor
    }                                      //mesmo com um if


    pessoa.idade?.let {
        pessoa.idade = it + 10             //COMPILA: coisas da linguagem ¯\_(ツ)_/¯
    }                                      //porem se a variavel fosse nula o let seria pulado.

    if(pessoa.idade == null){
        pessoa.idade = 10
    }else{
        pessoa.idade = pessoa.idade?.plus(10)    //PLUS - add um valor informado para outro valor
    }

    //OPERADOR ELVIS

    pessoa.idade = pessoa.idade?:0 + 10      //problema anterior resumido ainda mais gracas ao operador elvis

    /**
     * O operador Elvis é como se fosse um if ternário, sua sintaxe é “?:” ele faz uma
       verificação de nulo e atribui um valor a variável caso ela seja nula

     * */

    val saldo:Int? = null
    val novoSaldo = saldo?:0      // se a variavel for numa, o valor sera considerado 0 gracas ao elvis

//OPERADOR ELVIS + EXTENSIONS FUNCTIONS

/* Uma ideia legal é combinar o operador Elvis com uma extension Function.  poderíamos criar
uma extension de Int? chamada orZero que irá retornar um Int não nulo */

    fun Int?.orZero():Int {
        return this?:0
    }
    fun main() {
        val pessoa = Pessoa3("p1", 0)
        pessoa.idade = pessoa.idade.orZero() + 10
    }

}
