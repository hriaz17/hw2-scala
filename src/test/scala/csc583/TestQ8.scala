package csc583

import org.scalatest._

class TestQ8 extends FlatSpec with Matchers {
	val inputFilePath = "src/main/resources/Docs.txt"
	val invertedIndex = new InvertedIndex(inputFilePath)

	"Proximity model" should "answer Q8_1_1 correctly" in {
		val query = "schizophrenia /2 drug"
		val docs = invertedIndex.runQ8_1_1(query) 
		println(s"Ranked documents using the unsmoothed method: ${docs.mkString(", ")}")

		val ans1 = new Document("Doc1", 3, 1);
        val ans2 = new Document("Doc2", 1, 2);

		docs.size should be (2)
		docs(0) should be (ans1)
		docs(1) should be (ans2)
	}

	it should "answer Q8_1_2 correctly" in {
		val query = "schizophrenia /4 drug"
		val docs = invertedIndex.runQ8_1_2(query) 
		println(s"Ranked documents using the unsmoothed method: ${docs.mkString(", ")}")

		val ans1 = new Document("Doc1", 3, 1);
        val ans2 = new Document("Doc2", 1, 2);
        val ans3 = new Document("Doc3", 5, 2);

		docs.size should be (3)
		docs(0) should be (ans1)
		docs(1) should be (ans2)
		docs(2) should be (ans3)
	}

	it should "answer Q8_2 correctly" in {
		val query = "schizophrenia /4 drug"
		val docs = invertedIndex.runQ8_2(query) 
		println(s"Ranked documents using the unsmoothed method: ${docs.mkString(", ")}")

        val ans1 = new Document("Doc2", 1, 2);

		docs.size should be (1)
		docs(0) should be (ans1)
	}
}