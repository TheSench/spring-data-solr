package org.springframework.data.solr.core.query;

/**
 * DisMax Options.
 * Reference in Solr:
 * https://github.com/apache/lucene-solr/blob/ec78ef785275e4d46c0f133c6b55be1f974b8db2/solr/core/src/java/org/apache/solr/search/ExtendedDismaxQParser.java
 *
 * @author Matthew Hall
 * @author Jon Senchyna
 */
public class EDisMaxOptions extends DisMaxOptions {

  private Boolean splitOnWhitespace;
  private Boolean autoRelaxMinimumShouldMatch;
  private String boost;
  private Boolean allowLowercaseOperators;
  private Integer phraseSlop2;
  private Integer phraseSlop3;
  private String phraseFields2;
  private String phraseFields3;
  private Boolean stopwords;
  private String userFields;
  private String queryFields;



  /**
   * Maps to the <code>sow</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * <p>
   * If <code>false</code>, whitespace-separated term sequences will be
   * provided to text analysis in one shot.
   * <p>
   * If <code>true</code>, text analysis is invoked separately for each
   * individual whitespace-separated term.
   * 
   * @return whether to split on whitespace
   */
  public Boolean shouldSplitOnWhitespace() {
    return this.splitOnWhitespace;
  }

  /**
   * Maps to the <code>mm.autoRelax</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * <p>
   * If <code>true</code>, the number of clauses required (minimum should
   * match) will automatically be relaxed if a clause is removed (by e.g.,
   * stopwords filter) from some but not all qf fields.
   * 
   * @return whether to auto-relax minimum-should-match if clauses are removed
   */
  public Boolean shouldAutoRelaxMinimumShouldMatch() {
    return this.autoRelaxMinimumShouldMatch;
  }

  /**
   * Maps to the <code>boost</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * <p>
   * A multivalued list of strings parsed as queries with scores multiplied by
   * the score from the main query for all matching documents.
   * 
   * @return 
   */
  public String getBoost() {
    return this.boost;
  }

  /**
   * Maps to the <code>lowercaseOperators</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * 
   * @return whether to treat lowercase <code>and</code> and <code>or</code>
   * the same as uppercase operators<code>AND</code> and <code>OR</code>.
   */
  public Boolean shouldAllowLowercaseOperators() {
    return this.allowLowercaseOperators;
  }


  /**
   * Maps to the <code>ps</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * 
   * @return the default amount of slop on phrase queries built with
   * <code>pf</code>, <code>pf2</code> and/or <code>pf3</code> fields (affects
   * boosting).
   */
  @Override
  public Integer getPhraseSlop() {
    // Overriding to provide eDisMax Javadoc
    return super.getPhraseSlop();
  }

  /**
   * Maps to the <code>ps2</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * <p>
   * Overrides the slop factor for the <code>pf2</code> field (affects
   * boosting).
   * 
   * @return the slop factor used for the <code>pf2</code> field.
   */
  public Integer getPhraseSlop2() {
    return this.phraseSlop2;
  }

  /**
   * Maps to the <code>ps3</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * <p>
   * Overrides the slop factor for the <code>pf3</code> field (affects
   * boosting).
   * 
   * @return the slop factor used for the <code>pf3</code> field.
   */
  public Integer getPhraseSlop3() {
    return this.phraseSlop3;
  }

  /**
   * Maps to the <code>pf2</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * <p>
   * A multivalued list of fields with optional weights. Similar to pf, but
   * based on word <em>pair</em> shingles.
   * 
   * @return 
   */
  public String getPhraseFields2() {
    return this.phraseFields2;
  }

  /**
   * Maps to the <code>pf2</code> parameter.
   * <p>
   * See https://lucene.apache.org/solr/guide/{SOLR_VERSION}/the-extended-dismax-query-parser.html#extended-dismax-parameters
   * <p>
   * A multivalued list of fields with optional weights. Similar to pf, but
   * based on word <em>triplet</em> shingles.
   * 
   * @return 
   */
  public String getPhraseFields3() {
    return this.phraseFields3;
  }

  public Boolean isStopwords() {
    return this.stopwords;
  }

  public String getUserFields() {
    return this.userFields;
  }

  public String getQueryFields() {
    return this.queryFields;
  }

  private EDisMaxOptions(String altQuery, String queryFunction, String minimumMatch, String boostQuery,
  String boostFunction, Integer phraseSlop, Integer querySlop, Double tie, String phraseFunction,
  String defaultField) {
    super(altQuery, queryFunction, minimumMatch, boostQuery, boostFunction,
      phraseSlop, querySlop, tie, phraseFunction, defaultField);
  }


  public static class Builder extends DisMaxOptions.Builder {

    private Boolean splitOnWhitespace;
    private Boolean autoRelaxMinimumShouldMatch;
    private String boost;
    private Boolean allowLowercaseOperators;
    private Integer phraseSlop2;
    private Integer phraseSlop3;
    private String phraseFields2;
    private String phraseFields3;
    private Boolean stopwords;
    private String userFields;
    private String queryFields;

    public Builder() {}

    public Builder splitOnWhitespace(Boolean splitOnWhitespace) {
      this.splitOnWhitespace = splitOnWhitespace;
      return this;
    }

    public Builder autoRelaxMinimumShouldMatch(Boolean autoRelaxMinimumShouldMatch) {
      this.autoRelaxMinimumShouldMatch = autoRelaxMinimumShouldMatch;
      return this;
    }

    public Builder boost(String boost) {
      this.boost = boost;
      return this;
    }

    public Builder allowLowercaseOperators(Boolean allowLowercaseOperators) {
      this.allowLowercaseOperators = allowLowercaseOperators;
      return this;
    }

    public Builder phraseSlop(Integer phraseSlop) {
      return (Builder) super.phraseSlop(phraseSlop);
    }

    public Builder phraseSlop2(Integer phraseSlop2) {
      this.phraseSlop2 = phraseSlop2;
      return this;
    }

    public Builder phraseSlop3(Integer phraseSlop3) {
      this.phraseSlop3 = phraseSlop3;
      return this;
    }

    public Builder phraseFields2(String phraseFields2) {
      this.phraseFields2 = phraseFields2;
      return this;
    }

    public Builder phraseFields3(String phraseFields3) {
      this.phraseFields3 = phraseFields3;
      return this;
    }

    public Builder stopwords(Boolean stopwords) {
      this.stopwords = stopwords;
      return this;
    }

    public Builder userFields(String userFields) {
      this.userFields = userFields;
      return this;
    }

    public Builder queryFields(String queryFields) {
      this.queryFields = queryFields;
      return this;
    }


    public EDisMaxOptions build() {
      EDisMaxOptions options = new EDisMaxOptions(altQuery, queryFunction, minimumMatch, boostQuery, boostFunction,
        phraseSlop, querySlop, tie, phraseFunction, defaultField);

        options.splitOnWhitespace = this.splitOnWhitespace;
        options.autoRelaxMinimumShouldMatch = this.autoRelaxMinimumShouldMatch;
        options.boost = this.boost;
        options.allowLowercaseOperators = this.allowLowercaseOperators;
        options.phraseSlop = this.phraseSlop;
        options.phraseSlop2 = this.phraseSlop2;
        options.phraseSlop3 = this.phraseSlop3;
        options.phraseFields2 = this.phraseFields2;
        options.phraseFields3 = this.phraseFields3;
        options.stopwords = this.stopwords;
        options.userFields = this.userFields;
        options.queryFields = this.queryFields;

        return options;
    }
  }
}
