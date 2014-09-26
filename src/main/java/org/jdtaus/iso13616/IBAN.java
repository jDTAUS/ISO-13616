// SECTION-START[License Header]
// <editor-fold defaultstate="collapsed" desc=" Generated License ">
/*
 *   jDTAUS ⁑ ISO-13616
 *   Copyright (C) Christian Schulte, 2013-222
 *
 *   Permission to use, copy, modify, and/or distribute this software for any
 *   purpose with or without fee is hereby granted, provided that the above
 *   copyright notice and this permission notice appear in all copies.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 *   WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 *   MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 *   ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 *   WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 *   ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 *   OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 *   $JDTAUS$
 *
 */
// </editor-fold>
// SECTION-END
package org.jdtaus.iso13616;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.math.BigInteger;
import java.net.URL;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formattable;
import java.util.Formatter;
import java.util.HashMap;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import static java.util.FormattableFlags.ALTERNATE;
import static java.util.FormattableFlags.LEFT_JUSTIFY;
import static java.util.FormattableFlags.UPPERCASE;

// SECTION-START[Documentation]
// <editor-fold defaultstate="collapsed" desc=" Generated Documentation ">
/**
 *
 * International Bank Account Number.
 * <p>The IBAN structure is defined in ISO 13616-1 and consists of a two-letter ISO 3166-1 country code, followed by two
 * check digits and up to thirty alphanumeric characters for a BBAN (Basic Bank Account Number) which has a fixed length
 * per country and, included within it, a bank identifier with a fixed position and a fixed length per country. The
 * check digits are calculated based on the scheme defined in ISO/IEC 7064 (MOD97-10). The Society for Worldwide
 * Interbank Financial Telecommunication SCRL, SWIFT, has been designated by the ISO Technical Management Board to act
 * as the Registration Authority for ISO 13616. Nationally-agreed, ISO 13616-compliant IBAN formats are submitted to the
 * registration authority exclusively by the National Standards Body or the National Central Bank of the country. For
 * further information see the <a href="../../../doc-files/IBAN-Registry_Release-50_September-2014.pdf">IBAN REGISTRY</a>.
 * An updated version of the document may be found at <a href="http://www.swift.com">SWIFT</a>.</p>
 *
 * <dl>
 *   <dt><b>Identifier:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN</dd>
 *   <dt><b>Name:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN</dd>
 *   <dt><b>Abstract:</b></dt><dd>No</dd>
 *   <dt><b>Final:</b></dt><dd>Yes</dd>
 *   <dt><b>Stateless:</b></dt><dd>No</dd>
 * </dl>
 *
 * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
 * @version 1.1
 */
// </editor-fold>
// SECTION-END
// SECTION-START[Annotations]
// <editor-fold defaultstate="collapsed" desc=" Generated Annotations ">
@javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.7", comments = "See http://www.jomc.org/jomc/1.7/jomc-tools-1.7" )
// </editor-fold>
// SECTION-END
public final class IBAN implements CharSequence, Comparable<IBAN>, Formattable, Serializable
{
    // SECTION-START[IBAN]

    /**
     * International bank account number structure.
     * <p>The following character representations are used:
     * <table border="0">
     * <tr><td>a</td><td>Upper case letters (alphabetic characters A-Z only)</td></tr>
     * <tr><td>c</td><td>Upper and lower case alphanumeric characters (A-Z, a-z and 0-9)</td></tr>
     * <tr><td>e</td><td>Blank space</td></tr>
     * <tr><td>n</td><td>Digits (numeric characters 0 to 9 only)</td></tr>
     * </table></p>
     * <p>The following length indications are used:
     * <table border="0">
     * <tr><td>nn!</td><td>fixed length</td></tr>
     * <tr><td>nn</td><td>maximum length</td></tr>
     * </table></p>
     *
     * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
     * @version $JDTAUS$
     */
    private static final class Structure
    {

        /**
         * Part of a structure.
         *
         * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
         * @version $JDTAUS$
         */
        private static final class Part
        {

            /** Type of the part. */
            private final char type;

            /** The literal of the part or {@code null}. */
            private final String literal;

            /** The fixed length of the part or {@code null}. */
            private final Integer fixedLength;

            /** The maximum length of the part or {@code null}. */
            private final Integer maximumLength;

            /**
             * Creates a new {@code Part} instance.
             *
             * @param type The type of the part.
             * @param literal The literal of the part or {@code null}.
             * @param fixedLength The fixed length of the part or {@code null}.
             * @param maximumLength The maximum length of the part or {@code null}.
             */
            private Part( final char type, final String literal, final Integer fixedLength,
                          final Integer maximumLength )
            {
                super();
                this.type = type;
                this.literal = literal;
                this.fixedLength = fixedLength;
                this.maximumLength = maximumLength;
            }

            /**
             * Gets the type of the part.
             * <p>The following types are used:
             * <table border="0">
             * <tr><td>a</td><td>Upper case letters (alphabetic characters A-Z only)</td></tr>
             * <tr><td>c</td><td>Upper and lower case alphanumeric characters (A-Z, a-z and 0-9)</td></tr>
             * <tr><td>e</td><td>Blank space</td></tr>
             * <tr><td>n</td><td>Digits (numeric characters 0 to 9 only)</td></tr>
             * <tr><td>l</td><td>Literal</td></tr>
             * </table></p>
             *
             * @return The type of the part.
             */
            private char getType()
            {
                return this.type;
            }

            /**
             * Gets the literal of the part.
             *
             * @return The literal of the part or {@code null}, if the type of the part is not equal to {@code l}.
             */
            private String getLiteral()
            {
                return this.literal;
            }

            /**
             * Gets the fixed length of the part.
             *
             * @return The fixed length of the part or {@code null}, if the part has no fixed length but a maximum
             * length.
             */
            private Integer getFixedLength()
            {
                return this.fixedLength;
            }

            /**
             * Gets the maximum length of the part.
             *
             * @return The maximum length of the part or {@code null}, if the part has no maximum length but a fixed
             * length.
             */
            private Integer getMaximumLength()
            {
                return this.maximumLength;
            }

        }

        /** The parts of the structure. */
        private final List<Part> parts;

        /**
         * Creates a new {@code Structure} instance.
         *
         * @param parts The parts of the structure.
         */
        private Structure( final List<Part> parts )
        {
            super();
            this.parts = parts;
        }

        /**
         * Gets the parts of the structure.
         *
         * @return The parts of the structure.
         */
        private List<Part> getParts()
        {
            return this.parts;
        }

    }

    /**
     * Context of a parse operation.
     *
     * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
     * @version $JDTAUS$
     */
    private static final class ParseContext
    {

        /** The text to parse. */
        private final String text;

        /** The {@code ParsePosition} of the context. */
        private final ParsePosition parsePosition;

        /** The format to parse. */
        private final IbanFormat format;

        /** The number of electronic format characters parsed. */
        private int length;

        /** The previous character parsed. */
        private Character previous;

        /**
         * Creates a new {@code ParseContext} instance.
         *
         * @param text The text to parse.
         * @param pos The {@code ParsePosition} backing the parse.
         * @param format The format to parse.
         */
        private ParseContext( final String text, final ParsePosition pos, final IbanFormat format )
        {
            super();
            this.text = text;
            this.parsePosition = pos;
            this.format = format;
            this.length = 0;
        }

    }

    /** Serial version UID for backwards compatibility with 2007.45.x classes. */
    private static final long serialVersionUID = -8123668345632147105L;

    /** Used to cache instances. */
    private static volatile Reference<Map<String, IBAN>> cacheReference = new SoftReference<Map<String, IBAN>>( null );

    /** Mappings of two-letter ISO 3166-1 country codes to SEPA country flags. */
    private static final Map<String, Boolean> SEPA_COUNTRY_FLAGS = new HashMap<String, Boolean>( 128 );

    /** Mappings of two-letter ISO 3166-1 country codes to BBAN structures. */
    private static final Map<String, Structure> BBAN_STRUCTURES = new HashMap<String, Structure>( 128 );

    /** Mappings of two-letter ISO 3166-1 country codes to BBAN bank identifier part indices. */
    private static final Map<String, List<Number>> BBAN_BANK_ID_PARTS = new HashMap<String, List<Number>>( 128 );

    /** Mappings of two-letter ISO 3166-1 country codes to BBAN branch identifier part indices. */
    private static final Map<String, List<Number>> BBAN_BRANCH_ID_PARTS = new HashMap<String, List<Number>>( 128 );

    /** Mappings of two-letter ISO 3166-1 country codes to IBAN structures. */
    private static final Map<String, Structure> IBAN_STRUCTURES = new HashMap<String, Structure>( 128 );

    /** Mappings of two-letter ISO 3166-1 country codes to IBAN bank identifier part indices. */
    private static final Map<String, List<Number>> IBAN_BANK_ID_PARTS = new HashMap<String, List<Number>>( 128 );

    /** Mappings of two-letter ISO 3166-1 country codes to IBAN branch identifier part indices. */
    private static final Map<String, List<Number>> IBAN_BRANCH_ID_PARTS = new HashMap<String, List<Number>>( 128 );

    /** Mappings of two-letter ISO 3166-1 country codes to IBAN country codes. */
    private static final Map<String, String> IBAN_COUNTRY_CODES = new HashMap<String, String>( 128 );

    /** List of supported two-letter ISO 3166-1 country codes. */
    private static final List<String> COUNTRIES = new ArrayList<String>( 128 );

    /** {@code BigInteger} constant {@code 97}. */
    private static final BigInteger INTEGER_97 = BigInteger.valueOf( 97L );

    /** {@code BigInteger} constant {@code 98}. */
    private static final BigInteger INTEGER_98 = BigInteger.valueOf( 98L );

    static
    {
        InputStream in = null;

        try
        {
            final Properties properties = new Properties();
            final URL resource = IBAN.class.getResource( "IBAN.properties" );
            assert resource != null : "Expected resource 'IBAN.properties' to exist.";

            if ( resource != null )
            {
                in = resource.openStream();
                properties.load( in );
                in.close();
                in = null;

                if ( properties.containsKey( "countries" ) )
                {
                    final String[] countries = properties.getProperty( "countries" ).split( "\\|" );
                    COUNTRIES.addAll( Arrays.asList( countries ) );

                    for ( int i = 0, s0 = countries.length; i < s0; i++ )
                    {
                        if ( countries[i].length() != 2 )
                        {
                            throw new AssertionError( countries[i] );
                        }

                        final String bbanStructure = properties.getProperty( countries[i] + ".bban.structure" );
                        final String bbanBankIds = properties.getProperty( countries[i] + ".bban.bankidparts" );
                        final String bbanBranchIds = properties.getProperty( countries[i] + ".bban.branchidparts" );
                        final String ibanCountryCode = properties.getProperty( countries[i] + ".iban.countrycode" );
                        final String ibanStructure = properties.getProperty( countries[i] + ".iban.structure" );
                        final String ibanBankIds = properties.getProperty( countries[i] + ".iban.bankidparts" );
                        final String ibanBranchIds = properties.getProperty( countries[i] + ".iban.branchidparts" );
                        final String sepa = properties.getProperty( countries[i] + ".sepa" );

                        SEPA_COUNTRY_FLAGS.put( countries[i], Boolean.valueOf( sepa ) );

                        if ( ibanCountryCode != null )
                        {
                            IBAN_COUNTRY_CODES.put( countries[i], ibanCountryCode );
                        }

                        if ( bbanStructure != null )
                        {
                            BBAN_STRUCTURES.put( countries[i], parseStructure( bbanStructure ) );
                            assert bbanBankIds != null :
                                "Expected '" + countries[i] + ".bban.bankidparts' property to exists.";

                            if ( bbanBankIds != null )
                            {
                                BBAN_BANK_ID_PARTS.put( countries[i], splitNumbers( bbanBankIds ) );
                            }

                            if ( bbanBranchIds != null )
                            {
                                BBAN_BRANCH_ID_PARTS.put( countries[i], splitNumbers( bbanBranchIds ) );
                            }
                        }

                        if ( ibanStructure != null )
                        {
                            IBAN_STRUCTURES.put( countries[i], parseStructure( ibanStructure ) );
                            assert ibanBankIds != null :
                                "Expected '" + countries[i] + ".iban.bankidparts' property to exists.";

                            if ( ibanBankIds != null )
                            {
                                IBAN_BANK_ID_PARTS.put( countries[i], splitNumbers( ibanBankIds ) );
                            }

                            if ( ibanBranchIds != null )
                            {
                                IBAN_BRANCH_ID_PARTS.put( countries[i], splitNumbers( ibanBranchIds ) );
                            }
                        }
                    }
                }
            }
        }
        catch ( final ParseException e )
        {
            throw new AssertionError( e );
        }
        catch ( final IOException e )
        {
            throw new AssertionError( e );
        }
        finally
        {
            try
            {
                if ( in != null )
                {
                    in.close();
                }
            }
            catch ( final IOException e )
            {
                throw new AssertionError( e );
            }
        }
    }

    /** Maximum number of characters of an {@code IBAN}. */
    public static final int MAX_CHARACTERS = 42;

    /**
     * The two-letter ISO 3166-1 country code of the IBAN.
     * @serial
     */
    private String countryCode;

    /**
     * Flag indicating the country of the IBAN is part of the jurisdictional scope of the SEPA Schemes.
     * @serial
     */
    private boolean sepaCountry;

    /**
     * The bank identifier part of the BBAN of the IBAN.
     * @serial
     */
    private String bankIdentifier;

    /**
     * The branch identifier part of the BBAN of the IBAN.
     * @serial
     */
    private String branchIdentifier;

    /**
     * The electronic format of the IBAN.
     * @serial
     */
    private String electronicFormat;

    /**
     * The letter format of the IBAN.
     * @serial
     */
    private String letterFormat;

    /**
     * The parts of the IBAN.
     * @serial
     */
    private Comparable[] parts;

    /** Cached string representation of the instance. */
    private transient String string;

    /**
     * Creates a new {@code IBAN} instance.
     *
     * @param countryCode The two-letter ISO 3166-1 country code of the IBAN.
     * @param sepaCountry Flag indicating the country is part of the jurisdictional scope of the SEPA Schemes.
     * @param bankIdentifier The bank identifier part of the BBAN of the IBAN.
     * @param branchIdentifier The branch identifier part of the BBAN of the IBAN or {@code null}.
     * @param electronicFormat The electronic format representation of the IBAN.
     * @param letterFormat The letter format representation of the IBAN.
     * @param parts The parts of the IBAN.
     *
     * @see #parse(String, ParsePosition)
     */
    private IBAN( final String countryCode, final boolean sepaCountry, final String bankIdentifier,
                  final String branchIdentifier, final String electronicFormat, final String letterFormat,
                  final Comparable[] parts )
    {
        super();
        this.countryCode = countryCode;
        this.sepaCountry = sepaCountry;
        this.bankIdentifier = bankIdentifier;
        this.branchIdentifier = branchIdentifier;
        this.electronicFormat = electronicFormat;
        this.letterFormat = letterFormat;
        this.parts = parts;
        getCache().put( electronicFormat, this );
        getCache().put( letterFormat, this );
    }

    /**
     * Gets an array holding two-letter ISO 3166-1 country codes of all countries that have implemented the IBAN
     * standard.
     *
     * @return An array holding two-letter ISO 3166-1 country codes of all countries that have implemented the IBAN
     * standard.
     */
    public static String[] getCountryCodes()
    {
        return COUNTRIES.toArray( new String[ COUNTRIES.size() ] );
    }

    /**
     * Tests a given two-letter ISO 3166-1 country code to identify a country that is part of the jurisdictional scope
     * of the Single Euro Payment Area (SEPA) Schemes.
     * The <a href="../../../doc-files/EPC409-09 EPC List of SEPA Scheme Countries v2 0 - January 2014.pdf">
     * EPC List of SEPA Scheme Countries</a> document lists the countries and territories which are part of the
     * jurisdictional scope of the Single Euro Payment Area (SEPA) Schemes. An updated version of the document may be
     * found at <a href="http://www.europeanpaymentscouncil.eu">The European Payments Council (EPC)</a>.
     *
     * @param countryCode The two-letter ISO 3166-1 country code to test.
     *
     * @return {@code true}, if the country identified by {@code countryCode} is part of the jurisdictional scope of the
     * Single Euro Payment Area (SEPA) Schemes; {@code false}, if not.
     *
     * @throws NullPointerException if {@code countryCode} is {@code null}.
     *
     * @see #getCountryCodes()
     * @since 2007.46
     */
    public static boolean isSepaCountry( final String countryCode )
    {
        if ( countryCode == null )
        {
            throw new NullPointerException( "countryCode" );
        }

        final Boolean sepaCountry = SEPA_COUNTRY_FLAGS.get( countryCode );
        return sepaCountry != null ? sepaCountry : false;
    }

    /**
     * Gets the two-letter ISO 3166-1 country code identifying the country the IBAN belongs to.
     *
     * @return The two-letter ISO 3166-1 country code identifying the country the IBAN belongs to.
     *
     * @see #getCountryCodes()
     */
    public String getCountryCode()
    {
        return this.countryCode;
    }

    /**
     * Gets a flag indicating the country of the IBAN to be part of the jurisdictional scope of the Single Euro Payment
     * Area (SEPA) Schemes.
     *
     * @return {@code true}, if the country of the IBAN is part of the jurisdictional scope of the Single Euro Payment
     * Area (SEPA) Schemes; {@code false}, else.
     *
     * @see #getCountryCode()
     * @see #isSepaCountry(java.lang.String)
     */
    public boolean isSepaCountry()
    {
        return this.sepaCountry;
    }

    /**
     * Gets the bank identifier part of the BBAN of the IBAN.
     *
     * @return The bank identifier part of the BBAN of the IBAN.
     */
    public String getBankIdentifier()
    {
        return this.bankIdentifier;
    }

    /**
     * Gets the branch identifier part of the BBAN of the IBAN.
     *
     * @return The branch identifier part of the BBAN of the IBAN or {@code null}.
     */
    public String getBranchIdentifier()
    {
        return this.branchIdentifier;
    }

    /**
     * Parses text from a BBAN string to produce an {@code IBAN} instance.
     *
     * @param countryCode The two-letter ISO 3166-1 country code of the IBAN to create.
     * @param bban A string to parse BBAN characters from.
     *
     * @return The parsed value.
     *
     * @throws NullPointerException if {@code countryCode} or {@code bban} is {@code null}.
     * @throws IllegalArgumentException if the country identified by {@code countryCode} has not implemented the IBAN
     * standard, that is, {@code countryCode} is not contained in the array returned by method {@code getCountryCodes}.
     * @throws IbanSyntaxException if the parse fails or the length of {@code bban} is invalid.
     *
     * @see #getCountryCodes()
     * @see #valueOf(java.lang.String, java.lang.String)
     */
    public static IBAN parse( final String countryCode, final String bban ) throws IbanSyntaxException
    {
        if ( countryCode == null )
        {
            throw new NullPointerException( "countryCode" );
        }
        if ( bban == null )
        {
            throw new NullPointerException( "bban" );
        }

        final String ibanCountryCode = toIbanCountryCode( countryCode );
        final Structure structure = BBAN_STRUCTURES.get( ibanCountryCode );

        if ( structure == null )
        {
            throw new IllegalArgumentException( countryCode );
        }

        final List<Number> bankIdParts = BBAN_BANK_ID_PARTS.get( ibanCountryCode );
        final List<Number> branchIdParts = BBAN_BRANCH_ID_PARTS.get( ibanCountryCode );
        final boolean sepa_country = SEPA_COUNTRY_FLAGS.get( countryCode );

        // Parse the parts.
        final StringBuilder electronic_format_builder = new StringBuilder( MAX_CHARACTERS );
        final StringBuilder bank_id_builder = new StringBuilder( MAX_CHARACTERS );
        final StringBuilder branch_id_builder = new StringBuilder( MAX_CHARACTERS );
        final List<Comparable<?>> comparables = new ArrayList<Comparable<?>>( structure.getParts().size() + 2 );
        final ParseContext context =
            new ParseContext( bban, new ParsePosition( 0 ), bban.length() > 4 && bban.charAt( 4 ) == ' '
                                                                ? IbanFormat.PRINT : IbanFormat.ELECTRONIC );

        for ( int p = 0, s0 = structure.getParts().size(); p < s0 && context.parsePosition.getErrorIndex() < 0; p++ )
        {
            final Integer idKey = p + 1;
            final Structure.Part part = structure.getParts().get( p );
            final String chars = parsePart( context, part );

            if ( context.parsePosition.getErrorIndex() < 0 )
            {
                if ( part.getFixedLength() != null && chars.length() != part.getFixedLength().intValue() )
                { // Fixed length mismatch.
                    throw new IbanSyntaxException( bban, context.parsePosition.getIndex() );
                }

                electronic_format_builder.append( chars );

                if ( bankIdParts != null && bankIdParts.contains( idKey ) )
                {
                    bank_id_builder.append( chars );
                }
                if ( branchIdParts != null && branchIdParts.contains( idKey ) )
                {
                    branch_id_builder.append( chars );
                }

                switch ( part.getType() )
                {
                    case 'n':
                        comparables.add( new BigInteger( chars ) );
                        break;
                    default:
                        comparables.add( chars );
                        break;
                }
            }
            else
            { // Invalid part.
                throw new IbanSyntaxException( bban, context.parsePosition.getErrorIndex() );
            }
        }

        // Calculate checksum.
        final StringBuilder integer_builder = new StringBuilder( MAX_CHARACTERS * 2 );
        appendIso7064Digits( integer_builder, electronic_format_builder.toString() );
        appendIso7064Digits( integer_builder, ibanCountryCode );
        appendIso7064Digits( integer_builder, "00" );

        final BigInteger integer = new BigInteger( integer_builder.toString() );
        final BigInteger checksum = INTEGER_98.subtract( integer.remainder( INTEGER_97 ) );
        final String checksumPart = checksum.compareTo( BigInteger.TEN ) < 0 ? "0" + checksum : checksum.toString();

        comparables.add( 0, checksumPart );
        comparables.add( 0, ibanCountryCode );

        electronic_format_builder.insert( 0, checksumPart );
        electronic_format_builder.insert( 0, ibanCountryCode );

        return new IBAN( countryCode, sepa_country, bank_id_builder.toString(),
                         branch_id_builder.length() > 0 ? branch_id_builder.toString() : null,
                         electronic_format_builder.toString(), toLetterFormat( electronic_format_builder.toString() ),
                         comparables.toArray( new Comparable<?>[ comparables.size() ] ) );

    }

    /**
     * Parses text from a string to produce an {@code IBAN} instance.
     * <p>The method attempts to parse text starting at the index given by {@code pos}. If parsing succeeds, then the
     * index of {@code pos} is updated to the index after the last character used (parsing does not necessarily use all
     * characters up to the end of the string), and the parsed value is returned. The updated {@code pos} can be used to
     * indicate the starting point for the next call to this method.</p>
     *
     * @param text A string to parse IBAN characters from.
     * @param pos A {@code ParsePosition} object with index and error index information as described above.
     *
     * @return The parsed value or {@code null}, if the parse fails.
     *
     * @throws NullPointerException if {@code text} or {@code pos} is {@code null}.
     * @throws IbanCheckDigitsException if check digits validation of the parsed value fails.
     */
    public static IBAN parse( final String text, final ParsePosition pos ) throws IbanCheckDigitsException
    {
        if ( text == null )
        {
            throw new NullPointerException( "text" );
        }
        if ( pos == null )
        {
            throw new NullPointerException( "pos" );
        }

        IBAN ret = null;
        final int begin_index = pos.getIndex();

        // Extract the country code to query properties.
        if ( text.length() > begin_index + 1 )
        {
            final String country_code = text.substring( begin_index, begin_index + 2 );

            if ( !isLiteral( country_code.charAt( 0 ) ) )
            {
                pos.setIndex( begin_index );
                pos.setErrorIndex( begin_index );
            }
            else if ( !isLiteral( country_code.charAt( 1 ) ) )
            {
                pos.setIndex( begin_index );
                pos.setErrorIndex( begin_index + 1 );
            }
            else
            {
                final Structure structure = IBAN_STRUCTURES.get( country_code );

                if ( structure != null )
                { // Parse the parts.
                    final List<Number> bankIdParts = IBAN_BANK_ID_PARTS.get( country_code );
                    final List<Number> branchIdParts = IBAN_BRANCH_ID_PARTS.get( country_code );
                    final boolean sepa_country = SEPA_COUNTRY_FLAGS.get( country_code );
                    final StringBuilder electronic_format_builder = new StringBuilder( MAX_CHARACTERS );
                    final StringBuilder bank_id_builder = new StringBuilder( MAX_CHARACTERS );
                    final StringBuilder branch_id_builder = new StringBuilder( MAX_CHARACTERS );
                    final List<Comparable<?>> comparables = new ArrayList<Comparable<?>>( structure.getParts().size() );
                    final ParseContext context =
                        new ParseContext( text, pos,
                                          text.length() > begin_index + 4 && text.charAt( begin_index + 4 ) == ' '
                                              ? IbanFormat.PRINT : IbanFormat.ELECTRONIC );

                    for ( int p = 0, s0 = structure.getParts().size();
                          p < s0 && context.parsePosition.getErrorIndex() < 0;
                          p++ )
                    {
                        final Integer idKey = p + 1;
                        final Structure.Part part = structure.getParts().get( p );
                        final String chars = parsePart( context, part );

                        if ( context.parsePosition.getErrorIndex() < 0 )
                        {
                            if ( part.getFixedLength() != null && chars.length() != part.getFixedLength().intValue() )
                            { // Fixed length mismatch.
                                context.parsePosition.setErrorIndex( context.parsePosition.getIndex() );
                                context.parsePosition.setIndex( begin_index );
                                break;
                            }

                            electronic_format_builder.append( chars );

                            if ( bankIdParts != null && bankIdParts.contains( idKey ) )
                            {
                                bank_id_builder.append( chars );
                            }
                            if ( branchIdParts != null && branchIdParts.contains( idKey ) )
                            {
                                branch_id_builder.append( chars );
                            }

                            switch ( part.getType() )
                            {
                                case 'n':
                                    comparables.add( new BigInteger( chars ) );
                                    break;
                                default:
                                    comparables.add( chars );
                                    break;
                            }
                        }
                    }

                    if ( context.parsePosition.getErrorIndex() < 0 )
                    { // Validate checksum.
                        final StringBuilder integer_builder = new StringBuilder( MAX_CHARACTERS * 2 );
                        appendIso7064Digits( integer_builder, electronic_format_builder.substring( 4 ) );
                        appendIso7064Digits( integer_builder, electronic_format_builder.substring( 0, 4 ) );

                        final BigInteger integer = new BigInteger( integer_builder.toString() );

                        if ( integer.remainder( INTEGER_97 ).equals( BigInteger.ONE ) )
                        {
                            ret = new IBAN( country_code, sepa_country, bank_id_builder.toString(),
                                            branch_id_builder.length() > 0 ? branch_id_builder.toString() : null,
                                            electronic_format_builder.toString(),
                                            toLetterFormat( electronic_format_builder.toString() ),
                                            comparables.toArray( new Comparable<?>[ comparables.size() ] ) );

                        }
                        else
                        { // Invalid checksum.
                            context.parsePosition.setIndex( begin_index );
                            context.parsePosition.setErrorIndex( begin_index + 2 );

                            throw new IbanCheckDigitsException( electronic_format_builder.toString(),
                                                                (Number) comparables.get( 1 ) );

                        }
                    }
                }
                else
                { // Unsupported country code.
                    pos.setIndex( begin_index );
                    pos.setErrorIndex( begin_index + 1 );
                }
            }
        }
        else
        { // No country code provided.
            pos.setIndex( begin_index );
            pos.setErrorIndex( begin_index );

            if ( begin_index < text.length() && isLiteral( text.charAt( begin_index ) ) )
            {
                pos.setErrorIndex( begin_index + 1 );
            }
        }

        return ret;
    }

    /**
     * Parses text from the beginning of the given string to produce an {@code IBAN} instance.
     * <p>Unlike the {@link #parse(String, ParsePosition)} method this method throws an {@code IbanSyntaxException} if
     * {@code text} cannot be parsed or is of invalid length.</p>
     *
     * @param text A string to parse IBAN characters from.
     *
     * @return The parsed value.
     *
     * @throws NullPointerException if {@code text} is {@code null}.
     * @throws IbanSyntaxException if the parse fails or the length of {@code text} is invalid.
     * @throws IbanCheckDigitsException if check digits validation of the parsed value fails.
     *
     * @see #valueOf(java.lang.String)
     */
    public static IBAN parse( final String text ) throws IbanSyntaxException, IbanCheckDigitsException
    {
        if ( text == null )
        {
            throw new NullPointerException( "text" );
        }

        IBAN iban = getCache().get( text );

        if ( iban == null )
        {
            final ParsePosition pos = new ParsePosition( 0 );
            iban = IBAN.parse( text, pos );

            if ( iban == null || pos.getErrorIndex() != -1 || pos.getIndex() < text.length() )
            {
                throw new IbanSyntaxException( text, pos.getErrorIndex() != -1
                                                         ? pos.getErrorIndex()
                                                         : pos.getIndex() );

            }
        }

        return iban;
    }

    /**
     * Parses text from the beginning of the given string to produce an {@code IBAN} instance.
     * <p>Unlike the {@link #parse(String)} method this method throws an {@code IllegalArgumentException} if
     * {@code text} cannot be parsed, is of invalid length or check digits validation fails.</p>
     *
     * @param text A string to parse IBAN characters from.
     *
     * @return The parsed value.
     *
     * @throws NullPointerException if {@code text} is {@code null}.
     * @throws IllegalArgumentException if the parse fails, the length of {@code text} is invalid or if check digits
     * validation of the parsed value fails.
     *
     * @see #parse(java.lang.String)
     */
    public static IBAN valueOf( final String text )
    {
        if ( text == null )
        {
            throw new NullPointerException( "text" );
        }

        try
        {
            return IBAN.parse( text );
        }
        catch ( final IbanSyntaxException e )
        {
            throw new IllegalArgumentException( text, e );
        }
        catch ( final IbanCheckDigitsException e )
        {
            throw new IllegalArgumentException( text, e );
        }
    }

    /**
     * Parses text from a BBAN string to produce an {@code IBAN} instance.
     * <p>Unlike the {@link #parse(String, String)} method this method throws an {@code IllegalArgumentException} if the
     * parse fails or the length of {@code bban} is invalid.</p>
     *
     * @param countryCode The two-letter ISO 3166-1 country code of the IBAN to create.
     * @param bban A string to parse BBAN characters from.
     *
     * @return The parsed value.
     *
     * @throws NullPointerException if {@code countryCode} or {@code bban} is {@code null}.
     * @throws IllegalArgumentException if the country identified by {@code countryCode} has not implemented the IBAN
     * standard, that is, {@code countryCode} is not contained in the array returned by method {@code getCountryCodes},
     * if the parse fails, or if the length of {@code bban} is invalid.
     *
     * @see #parse(java.lang.String, java.lang.String)
     * @since 2007.46
     */
    public static IBAN valueOf( final String countryCode, final String bban )
    {
        if ( countryCode == null )
        {
            throw new NullPointerException( "countryCode" );
        }
        if ( bban == null )
        {
            throw new NullPointerException( "bban" );
        }

        try
        {
            return IBAN.parse( countryCode, bban );
        }
        catch ( final IbanSyntaxException e )
        {
            throw new IllegalArgumentException( bban, e );
        }
    }

    /**
     * Checks a given character to belong to the IBAN alphabet.
     *
     * @param c The character to check.
     *
     * @return {@code true} if {@code c} is a character of the IBAN alphabet; {@code false}, else.
     */
    public static boolean isIbanAlphabet( final char c )
    {
        return ( c >= 'A' && c <= 'Z' ) || ( c >= 'a' && c <= 'z' ) || ( c >= '0' && c <= '9' );
    }

    /**
     * Parses text from a string to peek at a national {@code IBAN} format.
     * <p>This method peeks at the given string to test whether it denotes a possibly valid national IBAN format.</p>
     *
     * @param text A string to peek at.
     *
     * @return {@code true}, if {@code text} denotes a (possibly partially) valid national IBAN format; {@code false},
     * if {@code text} does not denote a valid national IBAN format.
     *
     * @throws NullPointerException if {@code text} is {@code null}.
     * @throws IbanCheckDigitsException if check digits validation fails.
     */
    public static boolean peekIban( final String text ) throws IbanCheckDigitsException
    {
        if ( text == null )
        {
            throw new NullPointerException( "text" );
        }

        boolean valid = true;
        boolean complete = true;

        // Extract the country code to query properties.
        if ( text.length() > 1 )
        {
            final String country_code = text.substring( 0, 2 );
            final Structure structure = IBAN_STRUCTURES.get( country_code );

            if ( structure != null )
            { // Parse the parts.
                final StringBuilder electronic_format_builder = new StringBuilder( MAX_CHARACTERS );
                final ParseContext context =
                    new ParseContext( text, new ParsePosition( 0 ), text.length() > 4 && text.charAt( 4 ) == ' '
                                                                        ? IbanFormat.PRINT : IbanFormat.ELECTRONIC );

                for ( int p = 0, s0 = structure.getParts().size();
                      p < s0 && context.parsePosition.getErrorIndex() < 0 && complete;
                      p++ )
                {
                    final Structure.Part part = structure.getParts().get( p );
                    final String chars = parsePart( context, part );

                    if ( context.parsePosition.getErrorIndex() < 0 )
                    {
                        if ( part.getFixedLength() != null && chars.length() != part.getFixedLength().intValue() )
                        { // Fixed length mismatch.
                            complete = false;
                            break;
                        }

                        electronic_format_builder.append( chars );
                    }
                }

                if ( context.parsePosition.getErrorIndex() < 0 )
                {
                    if ( complete )
                    { // Validate checksum.
                        final StringBuilder integer_builder = new StringBuilder( MAX_CHARACTERS * 2 );
                        appendIso7064Digits( integer_builder, electronic_format_builder.substring( 4 ) );
                        appendIso7064Digits( integer_builder, electronic_format_builder.substring( 0, 4 ) );

                        final BigInteger integer = new BigInteger( integer_builder.toString() );

                        valid = integer.remainder( INTEGER_97 ).equals( BigInteger.ONE );

                        if ( !valid )
                        {
                            throw new IbanCheckDigitsException(
                                electronic_format_builder.toString(),
                                new BigInteger( electronic_format_builder.substring( 2, 4 ) ) );

                        }

                        if ( context.parsePosition.getIndex() != text.length() )
                        { // Unexpected length.
                            valid = false;
                        }
                    }
                }
                else
                { // Invalid part.
                    valid = false;
                }
            }
            else
            { // Unsupported country code.
                valid = false;
            }
        }
        else if ( text.length() > 0 && !( text.charAt( 0 ) >= 'A' && text.charAt( 0 ) <= 'Z' ) )
        { // Illegal first character.
            valid = false;
        }

        return valid;
    }

    /**
     * Formats an IBAN and appends the resulting text to a given {@code Appendable}.
     *
     * @param format The format to use.
     * @param appendable The {@code Appendable} to append the formatted IBAN to.
     *
     * @return The value passed in as {@code appendable}.
     *
     * @throws NullPointerException if {@code format} or {@code appendable} is {@code null}.
     * @throws IOException if appending fails.
     */
    public Appendable append( final IbanFormat format, final Appendable appendable ) throws IOException
    {
        if ( format == null )
        {
            throw new NullPointerException( "format" );
        }
        if ( appendable == null )
        {
            throw new NullPointerException( "appendable" );
        }

        switch ( format )
        {
            case ELECTRONIC:
                return appendable.append( this.electronicFormat );
            case PRINT:
                return appendable.append( this.letterFormat );
            default:
                throw new AssertionError( format );
        }
    }

    /**
     * Formats an IBAN to produce a string.
     *
     * @param format The format to use.
     *
     * @return The formatted string.
     *
     * @throws NullPointerException if {@code format} is {@code null}.
     */
    public String toString( final IbanFormat format )
    {
        if ( format == null )
        {
            throw new NullPointerException( "format" );
        }

        switch ( format )
        {
            case ELECTRONIC:
                return this.electronicFormat;
            case PRINT:
                return this.letterFormat;
            default:
                throw new AssertionError( format );
        }
    }

    /**
     * Formats the object using the provided {@code Formatter}.
     * <p>This method uses the {@code ELECTRONIC} format by default. The {@code PRINT} format can be used by specifying
     * the alternate form flag ({@code #}) in a format specifier.</p>
     *
     * @param formatter The {@code Formatter}.
     * @param flags The flags to modify the output format.
     * @param width The minimum number of characters to be written to the output.
     * @param precision The maximum number of characters to be written to the output.
     *
     * @throws IllegalFormatFlagsException if the {@code UPPERCASE} flag is set.
     */
    public void formatTo( final Formatter formatter, final int flags, final int width, final int precision )
    {
        if ( formatter == null )
        {
            throw new NullPointerException( "formatter" );
        }
        if ( ( flags & UPPERCASE ) == UPPERCASE )
        {
            final StringBuilder flagsBuilder = new StringBuilder( 3 );

            if ( ( flags & ALTERNATE ) == ALTERNATE )
            {
                flagsBuilder.append( "#" );
            }
            if ( ( flags & LEFT_JUSTIFY ) == LEFT_JUSTIFY )
            {
                flagsBuilder.append( "-" );
            }

            flagsBuilder.append( "^" );

            throw new IllegalFormatFlagsException( flagsBuilder.toString() );
        }

        final IbanFormat format = ( flags & ALTERNATE ) == ALTERNATE ? IbanFormat.PRINT : IbanFormat.ELECTRONIC;

        String str = this.toString( format );
        if ( precision != -1 && precision < str.length() )
        {
            str = str.substring( 0, precision );
        }

        final StringBuilder stringBuilder = new StringBuilder( str );

        if ( width != -1 )
        {
            final int len = width - stringBuilder.length();

            if ( len > 0 )
            {
                final char[] pad = new char[ len ];
                Arrays.fill( pad, ' ' );

                if ( ( flags & LEFT_JUSTIFY ) == LEFT_JUSTIFY )
                {
                    stringBuilder.append( pad );
                }
                else
                {
                    stringBuilder.insert( 0, pad );
                }
            }
        }

        formatter.format( stringBuilder.toString() );
    }

    /**
     * Returns the length of this character sequence.
     * <p>The length is the number of 16-bit {@code char}s in the sequence.</p>
     *
     * @return The number of {@code char}s in this sequence.
     */
    public int length()
    {
        return this.electronicFormat.length();
    }

    /**
     * Returns the {@code char} value at the specified index.
     * <p>An index ranges from zero to {@code length() - 1}. The first {@code char} value of the sequence is at index
     * zero, the next at index one, and so on, as for array indexing.</p>
     * <p>If the {@code char} value specified by the index is a surrogate, the surrogate value is returned.</p>
     *
     * @param index The index of the {@code char} value to return.
     *
     * @return The {@code char} value at {@code index}.
     *
     * @throws IndexOutOfBoundsException if {@code index} is negative or not less than the length of the character
     * sequence.
     *
     * @see #length()
     */
    public char charAt( final int index )
    {
        return this.electronicFormat.charAt( index );
    }

    /**
     * Returns a new {@code CharSequence} that is a subsequence of this sequence.
     * <p>The subsequence starts with the {@code char} value at the specified index and ends with the {@code char} value
     * at index {@code end - 1}. The length (in {@code char}s) of the returned sequence is {@code end - start}, so if
     * {@code start == end} then an empty sequence is returned.</p>
     *
     * @param start The start index, inclusive.
     * @param end The end index, exclusive.
     *
     * @return The subsequence starting at {@code start} up to {@code end -1}.
     *
     * @throws IndexOutOfBoundsException if {@code start} or {@code end} are negative, if {@code end} is greater than
     * the length of the character sequence, or if {@code start} is greater than {@code end}.
     */
    public CharSequence subSequence( final int start, final int end )
    {
        return this.electronicFormat.subSequence( start, end );
    }

    /**
     * Gets the hash code value of the object.
     *
     * @return The hash code value of the object.
     */
    @Override
    public int hashCode()
    {
        return this.electronicFormat.hashCode();
    }

    /**
     * Indicates whether some other object is equal to this one.
     *
     * @param o The reference object with which to compare.
     *
     * @return {@code true} if this object is the same as {@code o}; {@code false} otherwise.
     */
    @Override
    public boolean equals( final Object o )
    {
        boolean equal = this == o;

        if ( !equal && ( o instanceof IBAN ) )
        {
            equal = this.electronicFormat.equals( ( (IBAN) o ).electronicFormat );
        }

        return equal;
    }

    /**
     * Gets a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString()
    {
        return super.toString() + this.internalString();
    }

    /**
     * Compares this object with the specified object for order.
     * <p>IBAN comparison respects the national IBAN formats when comparing IBANs of the same country. Any country codes
     * and check digits are ignored.</p>
     *
     * @param o The Object to be compared.
     *
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     *
     * @throws NullPointerException if {@code o} is {@code null}.
     */
    public int compareTo( final IBAN o )
    {
        if ( o == null )
        {
            throw new NullPointerException( "o" );
        }

        int r = this.getCountryCode().compareTo( o.getCountryCode() );
        for ( int i = 2, s0 = this.parts.length; r == 0 && i < s0; r = this.parts[i].compareTo( o.parts[i] ), i++ );
        return r;
    }

    /**
     * Gets the current cache instance.
     *
     * @return Current cache instance.
     */
    private static Map<String, IBAN> getCache()
    {
        Map<String, IBAN> cache = cacheReference.get();

        if ( cache == null )
        {
            cache = new ConcurrentHashMap<String, IBAN>( 1024 );
            cacheReference = new SoftReference<Map<String, IBAN>>( cache );
        }

        return cache;
    }

    /**
     * Creates a string representing the properties of the instance.
     *
     * @return A string representing the properties of the instance.
     */
    private String internalString()
    {
        if ( this.string == null )
        {
            final StringBuilder b = new StringBuilder( 500 ).append( "{" );
            b.append( "countryCode=" ).append( this.countryCode ).
                append( ", sepaCountry=" ).append( this.sepaCountry ).
                append( ", bankIdentifier=" ).append( this.bankIdentifier ).
                append( ", branchIdentifier=" ).append( this.branchIdentifier ).
                append( ", electronicFormat=" ).append( this.electronicFormat ).
                append( ", letterFormat=" ).append( this.letterFormat ).
                append( ", parts={" );

            final StringBuilder partBuilder = new StringBuilder();
            for ( int i = 0, s0 = this.parts.length; i < s0; i++ )
            {
                partBuilder.append( ",[" ).append( i ).append( "]=" ).append( this.parts[i] );
            }

            this.string = b.append( partBuilder.substring( 1 ) ).append( "}}" ).toString();
        }

        return this.string;
    }

    /**
     * Parses a given structure string to produce a list of {@code Part}s.
     *
     * @param structure The structure string to parse.
     *
     * @return The parsed {@code Structure}.
     *
     * @throws ParseException if parsing {@code structure} fails.
     */
    private static Structure parseStructure( final String structure ) throws ParseException
    {
        boolean in_literal = false;
        boolean in_part = false;
        boolean fixed_length_part = false;
        final List<Structure.Part> parts = new ArrayList<Structure.Part>( IBAN.MAX_CHARACTERS );
        final StringBuilder literalBuilder = new StringBuilder( IBAN.MAX_CHARACTERS );
        final StringBuilder numberBuilder = new StringBuilder( IBAN.MAX_CHARACTERS );

        for ( int i = 0, s0 = structure.length(); i < s0; i++ )
        {
            final char c = structure.charAt( i );

            if ( in_part )
            {
                // Expect number or "(n|a|c|e)|!(n|a|c|e)"
                if ( isDigit( c ) )
                {
                    if ( fixed_length_part )
                    { // Expect type after length indicator.
                        throw new ParseException( structure, i );
                    }
                    numberBuilder.append( c );
                }
                else if ( isTypeIdentifier( c ) )
                {
                    if ( fixed_length_part )
                    {
                        parts.add( new Structure.Part( c, null, Integer.parseInt( numberBuilder.toString() ), null ) );
                    }
                    else
                    {
                        parts.add( new Structure.Part( c, null, null, Integer.parseInt( numberBuilder.toString() ) ) );
                    }
                    numberBuilder.setLength( 0 );
                    in_part = false;
                    fixed_length_part = false;
                }
                else if ( isLengthIndicator( c ) )
                {
                    if ( fixed_length_part )
                    { // Expect type after length indicator.
                        throw new ParseException( structure, i );
                    }
                    fixed_length_part = true;
                }
                else
                {
                    throw new ParseException( structure, i );
                }
            }
            else if ( in_literal )
            {
                // Expect literal or number starting a part.
                if ( isLiteral( c ) )
                {
                    literalBuilder.append( c );
                }
                else if ( isDigit( c ) )
                {
                    parts.add( new Structure.Part( 'l', literalBuilder.toString(), literalBuilder.length(), null ) );
                    numberBuilder.append( c );
                    literalBuilder.setLength( 0 );
                    in_part = true;
                    in_literal = false;
                }
                else
                {
                    throw new ParseException( structure, i );
                }
            }
            else
            {
                if ( fixed_length_part )
                { // Expect type after length indicator.
                    throw new ParseException( structure, i );
                }

                // Expect number starting a part or upper-case letter starting a literal.
                if ( isDigit( c ) )
                {
                    numberBuilder.append( c );
                    in_part = true;
                }
                else if ( isLiteral( c ) )
                {
                    literalBuilder.append( c );
                    in_literal = true;
                }
                else
                {
                    throw new ParseException( structure, i );
                }
            }
        }

        if ( fixed_length_part )
        { // Expect type after length indicator.
            throw new ParseException( structure, structure.length() );
        }

        if ( in_part )
        { // Unclosed part.
            throw new ParseException( structure, structure.length() );
        }

        if ( in_literal )
        { // Literal at end of structure.
            parts.add( new Structure.Part( 'l', literalBuilder.toString(), literalBuilder.length(), null ) );
        }

        return new Structure( parts );
    }

    /**
     * Parses text from a string according to a given {@code Part} to produce a {@code String} instance.
     *
     * @param context The context of the parse.
     * @param part The {@code Part} to parse.
     *
     * @return The parsed value, or {@code null} if the parse fails.
     */
    private static String parsePart( final ParseContext context, final Structure.Part part )
    {
        final StringBuilder partBuilder = new StringBuilder( MAX_CHARACTERS );
        final int start_index = context.parsePosition.getIndex();

        next:
        for ( int index = context.parsePosition.getIndex(), text_len = context.text.length(), literal_index = 0,
            part_len = part.getFixedLength() != null
                           ? part.getFixedLength().intValue() : part.getMaximumLength().intValue();
              index < text_len && index - start_index < part_len; index++, context.parsePosition.setIndex( index ) )
        {
            final char current = context.text.charAt( index );

            if ( current == ' ' && part.getType() != 'e' )
            {
                if ( context.format == IbanFormat.PRINT && context.length % 4 == 0
                         && ( context.previous == null || context.previous.charValue() != ' ' ) )
                { // Skip letter format separator.
                    part_len++;
                    context.previous = Character.valueOf( current );
                    continue next;
                }
                else
                { // Unexpected letter format separator.
                    context.parsePosition.setIndex( start_index );
                    context.parsePosition.setErrorIndex( index );
                    break next;
                }
            }

            switch ( part.getType() )
            {
                case 'a':
                    // Upper case letters (alphabetic characters A-Z only)
                    if ( current >= 'A' && current <= 'Z' )
                    {
                        partBuilder.append( current );
                        context.length++;
                    }
                    else
                    {
                        context.parsePosition.setIndex( start_index );
                        context.parsePosition.setErrorIndex( index );
                    }
                    break;
                case 'c':
                    // Upper and lower case alphanumeric characters (A-Z, a-z and 0-9)
                    if ( ( current >= 'A' && current <= 'Z' )
                             || ( current >= 'a' && current <= 'z' )
                             || ( current >= '0' && current <= '9' ) )
                    {
                        partBuilder.append( current );
                        context.length++;
                    }
                    else
                    {
                        context.parsePosition.setIndex( start_index );
                        context.parsePosition.setErrorIndex( index );
                    }
                    break;
                case 'e':
                    // blank space
                    if ( current == ' ' )
                    {
                        partBuilder.append( current );
                        context.length++;
                    }
                    else
                    {
                        context.parsePosition.setIndex( start_index );
                        context.parsePosition.setErrorIndex( index );
                    }
                    break;
                case 'n':
                    // Digits (numeric characters 0 to 9 only)
                    if ( current >= '0' && current <= '9' )
                    {
                        partBuilder.append( current );
                        context.length++;
                    }
                    else
                    {
                        context.parsePosition.setIndex( start_index );
                        context.parsePosition.setErrorIndex( index );
                    }
                    break;
                case 'l':
                    // Literal
                    if ( current == part.getLiteral().charAt( literal_index++ ) )
                    {
                        context.length++;
                        partBuilder.append( current );
                    }
                    else
                    {
                        context.parsePosition.setIndex( start_index );
                        context.parsePosition.setErrorIndex( index );
                    }
                    break;
                default:
                    context.parsePosition.setIndex( start_index );
                    context.parsePosition.setErrorIndex( index );
                    break next;
            }

            context.previous = Character.valueOf( current );
        }

        return context.parsePosition.getErrorIndex() < 0 ? partBuilder.toString() : null;
    }

    /**
     * Tests a given character to conform to a literal.
     *
     * @param c The character to test.
     *
     * @return {@code true}, if {@code c} conforms to a literal; {@code false}, else.
     */
    private static boolean isLiteral( final char c )
    {
        return ( c >= 'A' && c <= 'Z' );
    }

    /**
     * Tests a given character to conform to a digit.
     *
     * @param c The character to test.
     *
     * @return {@code true}, if {@code c} conforms to a digit; {@code false}, else.
     */
    private static boolean isDigit( final char c )
    {
        return ( c >= '0' && c <= '9' );
    }

    /**
     * Tests a given character to conform to a type identifier.
     *
     * @param c The character to test.
     *
     * @return {@code true}, if {@code c} conforms to a type identifier; {@code false}, else.
     */
    private static boolean isTypeIdentifier( final char c )
    {
        return c == 'a' || c == 'c' || c == 'e' || c == 'n';
    }

    /**
     * Tests a given character to conform to a length indicator.
     *
     * @param c The character to test.
     *
     * @return {@code true}, if {@code c} conforms to a length indicator; {@code false}, else.
     */
    private static boolean isLengthIndicator( final char c )
    {
        return c == '!';
    }

    /**
     * Splits a given string containing numbers separated by {@code |} characters to a list of numbers.
     *
     * @param str The string to split.
     *
     * @return The numbers of {@code str}.
     */
    private static List<Number> splitNumbers( final String str )
    {
        final String[] parts = str.split( "\\|" );
        final List<Number> numbers = new ArrayList<Number>( parts.length );
        for ( int i = 0, l0 = parts.length; i < l0; numbers.add( Integer.valueOf( parts[i] ) ), i++ );
        return numbers;
    }

    /**
     * Translates characters to digits according to the MOD 97-10 (ISO 7064) algorithm.
     *
     * @param buffer The buffer to append digits to.
     * @param chars The characters to translate.
     */
    private static void appendIso7064Digits( final StringBuilder buffer, final String chars )
    {
        for ( int i = 0, l0 = chars.length(); i < l0; i++ )
        {
            final char c = chars.charAt( i );

            if ( c >= 'A' && c <= 'Z' )
            {
                buffer.append( Integer.toString( ( c - 'A' ) + 10 ) );
            }
            else if ( c >= 'a' && c <= 'z' )
            {
                buffer.append( Integer.toString( ( c - 'a' ) + 10 ) );
            }
            else if ( c >= '0' && c <= '9' )
            {
                buffer.append( c );
            }
            else
            {
                throw new AssertionError( c );
            }
        }
    }

    /**
     * Formats an electronic format IBAN to a letter format IBAN.
     *
     * @param electronicFormat An electronic format IBAN.
     *
     * @return The given IBAN formatted to the letter format representation.
     */
    private static String toLetterFormat( final String electronicFormat )
    {
        final StringBuilder letter_format_builder = new StringBuilder( electronicFormat.length() );

        for ( int i = 0, l0 = electronicFormat.length(); i < l0; i++ )
        {
            if ( i > 0 && i % 4 == 0 )
            {
                letter_format_builder.append( ' ' );
            }

            letter_format_builder.append( electronicFormat.charAt( i ) );
        }

        return letter_format_builder.toString();
    }

    private static String toIbanCountryCode( final String countryCode )
    {
        final String ibanCountryCode = IBAN_COUNTRY_CODES.get( countryCode );
        return ibanCountryCode != null ? ibanCountryCode : countryCode;
    }

    // SECTION-END
    // SECTION-START[Dependencies]
    // SECTION-END
    // SECTION-START[Properties]
    // SECTION-END
    // SECTION-START[Messages]
    // SECTION-END
}
