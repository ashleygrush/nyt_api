package NYT.Mappers;

import NYT.model.db.Article;
import NYT.model.db.Headlines;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
// talks directly to database and returns responses.
public interface NYTMapper {

    // string that inputs data into the articles database
    String INSERT_ARTICLE = "INSERT INTO `nyt`.`articles` (`headline`, `snippet`, `url`, `pub_date`) " +
            "VALUES (#{headline}, #{snippet}, #{url}, #{pub_date})";

    // string that inputs headline data into the headlines database.
    String INSERT_HEADLINE = "INSERT INTO `nyt`.`headlines` (`main`, `kicker`, `print_headline`) " +
            "VALUES (#{main}, #{kicker}, #{print_headline})";

    String SELECT_ARTICLES_KEYWORD = "SELECT * FROM nyt.articles where snippet like #{keyword} " +
            "or headline like #{keyword}";


    // inserts into articles in database
    @Insert(INSERT_ARTICLE)
    public int insertRecord(Article article);

    // inserts into the headlines database in the NYT database
    @Insert(INSERT_HEADLINE)
    public int insertHeadlineData(Headlines headline);

    // Translates into String object
    @Select(SELECT_ARTICLES_KEYWORD)
    public Article[] select_Keyword(String keyword);

}
