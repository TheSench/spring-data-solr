package org.springframework.data.solr.core.query;

/**
 * DisMax Options.
 *
 * @author Matthew Hall
 * @author Jon Senchyna
 */
public class EDisMaxOptions extends DisMaxOptions {

  private Boolean splitOnWhitespace;
  private Boolean autoRelaxMinimumShouldMatch;
  private String boost;
  private Boolean allowLowercaseOperators;
  private Integer phraseSlop;
  private Integer phraseSlop2;
  private Integer phraseSlop3;
  private String phraseFields2;
  private String phraseFields3;
  private Boolean stopwords;
  private String uf;
  private String qf;



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
    return this.phraseSlop;
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

  public String getUf() {
    return this.uf;
  }

  public String getQf() {
    return this.qf;
  }

  private EDisMaxOptions(String sow) {
    this.splitOnWhitespace = sow;
  }


  public static class Builder {

    private String sow;

    public Builder() {}

    public Builder sow(String sow) {
      this.sow = sow;
      return this;
    }

    public EDisMaxOptions build() {
      return new EDisMaxOptions(sow);
    }
  }
}
