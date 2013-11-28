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
package org.jdtaus.iso13616.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.IllegalFormatFlagsException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.jdtaus.iso13616.IBAN;
import org.jdtaus.iso13616.IbanCheckDigitsException;
import org.jdtaus.iso13616.IbanFormat;
import org.jdtaus.iso13616.IbanSyntaxException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

// SECTION-START[Documentation]
// <editor-fold defaultstate="collapsed" desc=" Generated Documentation ">
/**
 * Testcases for classes {@code org.jdtaus.iban.IBAN}, {@code org.jdtaus.iban.IbanSyntaxException} and {@code org.jdtaus.iban.IbanCheckDigitsException}.
 *
 * <dl>
 *   <dt><b>Identifier:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ Tests ⁑ IBAN Test</dd>
 *   <dt><b>Name:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ Tests ⁑ IBAN Test</dd>
 *   <dt><b>Abstract:</b></dt><dd>No</dd>
 *   <dt><b>Final:</b></dt><dd>Yes</dd>
 *   <dt><b>Stateless:</b></dt><dd>Yes</dd>
 * </dl>
 *
 * @author <a href="mailto:cs@schulte.it">Christian Schulte</a>
 * @version 1.0
 */
// </editor-fold>
// SECTION-END
// SECTION-START[Annotations]
// <editor-fold defaultstate="collapsed" desc=" Generated Annotations ">
@javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.5", comments = "See http://www.jomc.org/jomc/1.5/jomc-tools-1.5" )
// </editor-fold>
// SECTION-END
public class IbanTest
{
    // SECTION-START[IbanTest]

    /** Prefix for property names holding valid values formatted using electronic format. */
    private static final String VALID_ELECTRONIC_FORMAT_PREFIX = "valid.electronicformat";

    /** Prefix for property names holding valid values formatted using letter format. */
    private static final String VALID_LETTER_FORMAT_PREFIX = "valid.letterformat";

    /** Prefix for property names holding invalid values. */
    private static final String INVALID_PREFIX = "invalid.";

    /** Set of IBAN country codes. */
    private static final Set<String> IBAN_COUNTRY_CODES = new HashSet<String>( 128 );

    /** Set of EPC SEPA country codes. */
    private static final Set<String> SEPA_COUNTRY_CODES = new HashSet<String>( 128 );

    static
    {
        SEPA_COUNTRY_CODES.add( "AX" ); // Åland Islands - FI
        SEPA_COUNTRY_CODES.add( "AT" ); // Austria
        SEPA_COUNTRY_CODES.add( "PT" ); // Azores & Portugal
        SEPA_COUNTRY_CODES.add( "BE" ); // Belgium
        SEPA_COUNTRY_CODES.add( "BG" ); // Bulgaria
//        SEPA_COUNTRY_CODES.add( "IC" ); // Canary Islands - ES - Exceptional reservation
        SEPA_COUNTRY_CODES.add( "HR" ); // Croatia
        SEPA_COUNTRY_CODES.add( "CY" ); // Cyprus
        SEPA_COUNTRY_CODES.add( "CZ" ); // Czech Republic
        SEPA_COUNTRY_CODES.add( "DK" ); // Denmark
        SEPA_COUNTRY_CODES.add( "EE" ); // Estonia
        SEPA_COUNTRY_CODES.add( "FI" ); // Finland
        SEPA_COUNTRY_CODES.add( "FR" ); // France
        SEPA_COUNTRY_CODES.add( "GF" ); // French Guiana -FR
        SEPA_COUNTRY_CODES.add( "DE" ); // Germany
        SEPA_COUNTRY_CODES.add( "GI" ); // Gibraltar
        SEPA_COUNTRY_CODES.add( "GR" ); // Greece
        SEPA_COUNTRY_CODES.add( "GP" ); // Guadeloupe - FR
        SEPA_COUNTRY_CODES.add( "HU" ); // Hungary
        SEPA_COUNTRY_CODES.add( "IS" ); // Iceland
        SEPA_COUNTRY_CODES.add( "IE" ); // Ireland
        SEPA_COUNTRY_CODES.add( "IT" ); // Italy
        SEPA_COUNTRY_CODES.add( "LV" ); // Latvia
        SEPA_COUNTRY_CODES.add( "LI" ); // Liechtenstein
        SEPA_COUNTRY_CODES.add( "LT" ); // Lithuania
        SEPA_COUNTRY_CODES.add( "LU" ); // Luxembourg
        SEPA_COUNTRY_CODES.add( "MT" ); // Malta
        SEPA_COUNTRY_CODES.add( "MQ" ); // Martinique - FR
        SEPA_COUNTRY_CODES.add( "YT" ); // Mayotte - FR
        SEPA_COUNTRY_CODES.add( "MC" ); // Monaco
        SEPA_COUNTRY_CODES.add( "NL" ); // Netherlands
        SEPA_COUNTRY_CODES.add( "NO" ); // Norway
        SEPA_COUNTRY_CODES.add( "PL" ); // Poland
        SEPA_COUNTRY_CODES.add( "PT" ); // Madeira & Portugal
        SEPA_COUNTRY_CODES.add( "RE" ); // Réunion - FR
        SEPA_COUNTRY_CODES.add( "RO" ); // Romania
        SEPA_COUNTRY_CODES.add( "BL" ); // Saint Barthélemy - FR
        SEPA_COUNTRY_CODES.add( "MF" ); // Saint Martin (French part) - FR
        SEPA_COUNTRY_CODES.add( "PM" ); // Saint Pierre and Miquelon- FR
        SEPA_COUNTRY_CODES.add( "SK" ); // Slovakia
        SEPA_COUNTRY_CODES.add( "SI" ); // Slovenia
        SEPA_COUNTRY_CODES.add( "ES" ); // Canary Islands & Spain
        SEPA_COUNTRY_CODES.add( "SE" ); // Sweden
        SEPA_COUNTRY_CODES.add( "CH" ); // Switzerland
        SEPA_COUNTRY_CODES.add( "GB" ); // United Kingdom

        IBAN_COUNTRY_CODES.add( "AL" );
        IBAN_COUNTRY_CODES.add( "AD" );
        IBAN_COUNTRY_CODES.add( "AT" );
        IBAN_COUNTRY_CODES.add( "AZ" );
        IBAN_COUNTRY_CODES.add( "BH" );
        IBAN_COUNTRY_CODES.add( "BE" );
        IBAN_COUNTRY_CODES.add( "BA" );
        IBAN_COUNTRY_CODES.add( "BR" );
        IBAN_COUNTRY_CODES.add( "BG" );
        IBAN_COUNTRY_CODES.add( "CR" );
        IBAN_COUNTRY_CODES.add( "HR" );
        IBAN_COUNTRY_CODES.add( "CY" );
        IBAN_COUNTRY_CODES.add( "CZ" );
        IBAN_COUNTRY_CODES.add( "DK" );
        IBAN_COUNTRY_CODES.add( "FO" );
        IBAN_COUNTRY_CODES.add( "GL" );
        IBAN_COUNTRY_CODES.add( "DO" );
        IBAN_COUNTRY_CODES.add( "EE" );
        IBAN_COUNTRY_CODES.add( "FI" );
        IBAN_COUNTRY_CODES.add( "AX" );
        IBAN_COUNTRY_CODES.add( "FR" );
        IBAN_COUNTRY_CODES.add( "GF" );
        IBAN_COUNTRY_CODES.add( "GP" );
        IBAN_COUNTRY_CODES.add( "MQ" );
        IBAN_COUNTRY_CODES.add( "RE" );
        IBAN_COUNTRY_CODES.add( "PF" );
        IBAN_COUNTRY_CODES.add( "TF" );
        IBAN_COUNTRY_CODES.add( "YT" );
        IBAN_COUNTRY_CODES.add( "NC" );
        IBAN_COUNTRY_CODES.add( "BL" );
        IBAN_COUNTRY_CODES.add( "MF" );
        IBAN_COUNTRY_CODES.add( "PM" );
        IBAN_COUNTRY_CODES.add( "WF" );
        IBAN_COUNTRY_CODES.add( "GE" );
        IBAN_COUNTRY_CODES.add( "DE" );
        IBAN_COUNTRY_CODES.add( "GI" );
        IBAN_COUNTRY_CODES.add( "GR" );
        IBAN_COUNTRY_CODES.add( "GT" );
        IBAN_COUNTRY_CODES.add( "HU" );
        IBAN_COUNTRY_CODES.add( "IS" );
        IBAN_COUNTRY_CODES.add( "IE" );
        IBAN_COUNTRY_CODES.add( "IL" );
        IBAN_COUNTRY_CODES.add( "IT" );
        IBAN_COUNTRY_CODES.add( "KZ" );
        IBAN_COUNTRY_CODES.add( "KW" );
        IBAN_COUNTRY_CODES.add( "LV" );
        IBAN_COUNTRY_CODES.add( "LB" );
        IBAN_COUNTRY_CODES.add( "LI" );
        IBAN_COUNTRY_CODES.add( "LT" );
        IBAN_COUNTRY_CODES.add( "LU" );
        IBAN_COUNTRY_CODES.add( "MK" );
        IBAN_COUNTRY_CODES.add( "MT" );
        IBAN_COUNTRY_CODES.add( "MR" );
        IBAN_COUNTRY_CODES.add( "MU" );
        IBAN_COUNTRY_CODES.add( "MD" );
        IBAN_COUNTRY_CODES.add( "MC" );
        IBAN_COUNTRY_CODES.add( "ME" );
        IBAN_COUNTRY_CODES.add( "NL" );
        IBAN_COUNTRY_CODES.add( "NO" );
        IBAN_COUNTRY_CODES.add( "PK" );
        IBAN_COUNTRY_CODES.add( "PS" );
        IBAN_COUNTRY_CODES.add( "PL" );
        IBAN_COUNTRY_CODES.add( "PT" );
        IBAN_COUNTRY_CODES.add( "RO" );
        IBAN_COUNTRY_CODES.add( "QA" );
        IBAN_COUNTRY_CODES.add( "SM" );
        IBAN_COUNTRY_CODES.add( "SA" );
        IBAN_COUNTRY_CODES.add( "RS" );
        IBAN_COUNTRY_CODES.add( "SK" );
        IBAN_COUNTRY_CODES.add( "SI" );
        IBAN_COUNTRY_CODES.add( "ES" );
        IBAN_COUNTRY_CODES.add( "SE" );
        IBAN_COUNTRY_CODES.add( "CH" );
        IBAN_COUNTRY_CODES.add( "TN" );
        IBAN_COUNTRY_CODES.add( "TR" );
        IBAN_COUNTRY_CODES.add( "AE" );
        IBAN_COUNTRY_CODES.add( "GB" );
        IBAN_COUNTRY_CODES.add( "JE" );
        IBAN_COUNTRY_CODES.add( "GG" );
        IBAN_COUNTRY_CODES.add( "IM" );
        IBAN_COUNTRY_CODES.add( "VG" );
    }

    /**
     * Gets an array of valid {@code IBAN} values formatted using electronic format.
     *
     * @return An array of valid {@code IBAN} values formatted using electronic format.
     *
     * @throws IOException if reading property resources fails.
     */
    private String[] getValidValuesElectronicFormat() throws IOException
    {
        final Map<Object, Object> properties = this.getProperties();
        final Collection<String> col = new LinkedList<String>();

        for ( final Iterator<Object> it = properties.keySet().iterator(); it.hasNext(); )
        {
            final String key = it.next().toString();
            if ( key.startsWith( VALID_ELECTRONIC_FORMAT_PREFIX ) )
            {
                col.add( properties.get( key ).toString() );
            }
        }

        return col.toArray( new String[ col.size() ] );
    }

    /**
     * Gets an array of valid {@code IBAN} values formatted using print format.
     *
     * @return An array of valid {@code IBAN} values formatted using print format.
     *
     * @throws IOException if reading property resources fails.
     */
    private String[] getValidValuesPrintFormat() throws IOException
    {
        final Map<Object, Object> properties = this.getProperties();
        final Collection<String> col = new LinkedList<String>();

        for ( final Iterator<Object> it = properties.keySet().iterator(); it.hasNext(); )
        {
            final String key = it.next().toString();
            if ( key.startsWith( VALID_LETTER_FORMAT_PREFIX ) )
            {
                col.add( properties.get( key ).toString() );
            }
        }

        return col.toArray( new String[ col.size() ] );
    }

    /**
     * Gets an array of invalid {@code IBAN} values.
     *
     * @return An array of invalid {@code IBAN} values.
     *
     * @throws IOException if reading property resources fails.
     */
    private String[] getInvalidValues() throws IOException
    {
        final Map<Object, Object> properties = this.getProperties();
        final Collection<String> col = new LinkedList<String>();

        for ( final Iterator<Object> it = properties.keySet().iterator(); it.hasNext(); )
        {
            final String key = it.next().toString();
            if ( key.startsWith( INVALID_PREFIX ) )
            {
                col.add( properties.get( key ).toString() );
            }
        }

        return col.toArray( new String[ col.size() ] );
    }

    private Map<Object, Object> getProperties() throws IOException
    {
        final Properties ret = new Properties();
        ret.load( this.getClass().getResourceAsStream( "IbanTest.properties" ) );
        return ret;
    }

    @Test public void CountryCodes() throws Exception
    {
        final String[] countryCodes = IBAN.getCountryCodes();
        assertNotNull( countryCodes );
        assertTrue( IBAN_COUNTRY_CODES.containsAll( Arrays.asList( countryCodes ) ) );
        assertTrue( Arrays.asList( countryCodes ).containsAll( IBAN_COUNTRY_CODES ) );

        final List<String> validCountries = Arrays.asList( Locale.getISOCountries() );

        for ( int i = 0, l0 = countryCodes.length; i < l0; i++ )
        {
            assertTrue( "Country '" + countryCodes[i] + "' is not a valid ISO country code.",
                        validCountries.contains( countryCodes[i] ) );

        }
    }

    @Test public void SepaCountry() throws Exception
    {
        try
        {
            IBAN.isSepaCountry( null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        for ( final String countryCode : SEPA_COUNTRY_CODES )
        {
            assertTrue( "Expected SEPA country '" + countryCode + "' not found.", IBAN.isSepaCountry( countryCode ) );
        }

        final Set<String> countriesWithoutSepa = new HashSet<String>( IBAN_COUNTRY_CODES );
        countriesWithoutSepa.removeAll( SEPA_COUNTRY_CODES );

        for ( final String countryCode : countriesWithoutSepa )
        {
            assertFalse( "Non-SEPA country '" + countryCode + "' flagged as SEPA.", IBAN.isSepaCountry( countryCode ) );
        }

        final Set<String> sepaCountries = new HashSet<String>( IBAN_COUNTRY_CODES );
        sepaCountries.retainAll( SEPA_COUNTRY_CODES );

        for ( final String countryCode : sepaCountries )
        {
            assertTrue( "Expected SEPA country '" + countryCode + "' not found.", IBAN.isSepaCountry( countryCode ) );
        }

        assertFalse( IBAN.isSepaCountry( "NOT_A_COUNTRY_CODE" ) );
    }

    @Test public void CharSequence() throws Exception
    {
        final IBAN iban = IBAN.parse( "AL47212110090000000235698741" );

        System.out.println( iban.toString() );

        assertTrue( iban.length() == "AL47212110090000000235698741".length() );
        assertTrue( iban.charAt( 0 ) == 'A' );
        assertTrue( iban.charAt( "AL47212110090000000235698741".length() - 1 ) == '1' );

        try
        {
            iban.charAt( "AL47212110090000000235698741".length() );
            fail( "Expected 'IndexOutOfBoundsException' not thrown." );
        }
        catch ( final IndexOutOfBoundsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            iban.subSequence( -1, 0 );
            fail( "Expected 'IndexOutOfBoundsException' not thrown." );
        }
        catch ( final IndexOutOfBoundsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }
        try
        {
            iban.subSequence( 0, -1 );
            fail( "Expected 'IndexOutOfBoundsException' not thrown." );
        }
        catch ( final IndexOutOfBoundsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        assertEquals( "AL47212110090000000235698741", iban.subSequence( 0, "AL47212110090000000235698741".length() ) );
        assertEquals( "AL", iban.subSequence( 0, 2 ) );
    }

    @Test public void ParseElectronicFormat() throws Exception
    {
        final String[] valid = this.getValidValuesElectronicFormat();

        for ( int i = valid.length - 1; i >= 0; i-- )
        {
            final IBAN iban = IBAN.parse( valid[i] );
            assertEquals( valid[i], iban.toString( IbanFormat.ELECTRONIC ) );
            System.out.println( iban.toString() );
        }
    }

    @Test public void ParseLetterFormat() throws Exception
    {
        final String[] valid = this.getValidValuesPrintFormat();

        for ( int i = valid.length - 1; i >= 0; i-- )
        {
            final IBAN iban = IBAN.parse( valid[i] );
            assertEquals( valid[i], iban.toString( IbanFormat.PRINT ) );
            System.out.println( iban.toString() );
        }
    }

    @Test public void ParseBban() throws Exception
    {
        final IBAN iban = IBAN.parse( "AL47212110090000000235698741" );

        try
        {
            IBAN.parse( "TEST", (String) null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            IBAN.parse( null, "TEST" );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            IBAN.parse( "TEST", "212110090000000235698741" );
            fail( "Expected 'IllegalArgumentException' not thrown." );
        }
        catch ( final IllegalArgumentException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        assertEquals( iban, IBAN.parse( "AL", "212110090000000235698741" ) );

        // 3!n4!n1!n16!c
        try
        {
            IBAN.parse( "AL", "21211009235698741" );
            fail( "Expected 'IbanSyntaxException' not thrown." );
        }
        catch ( final IbanSyntaxException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
            assertTrue( e.getErrorIndex() == "21211009235698741".length() );
        }
        try
        {
            IBAN.parse( "AL", "2X2110090000000235698741" );
            fail( "Expected 'IbanSyntaxException' not thrown." );
        }
        catch ( final IbanSyntaxException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
            assertTrue( e.getErrorIndex() == 1 );
        }
    }

    @Test public void ParseIbanAtPosition() throws Exception
    {
        final String[] validElectronicFormat = this.getValidValuesElectronicFormat();
        final String[] validPrintFormat = this.getValidValuesPrintFormat();
        final String[] invalid = this.getInvalidValues();

        try
        {
            IBAN.parse( "TEST", (ParsePosition) null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            IBAN.parse( null, new ParsePosition( 0 ) );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        ParsePosition pos = new ParsePosition( 0 );
        IBAN.parse( "", pos );
        assertTrue( pos.getErrorIndex() == 0 );

        pos = new ParsePosition( 0 );
        IBAN.parse( "0", pos );
        assertTrue( pos.getErrorIndex() == 0 );

        pos = new ParsePosition( 0 );
        IBAN.parse( "00", pos );
        assertTrue( pos.getErrorIndex() == 0 );

        pos = new ParsePosition( 0 );
        IBAN.parse( "X", pos );
        assertTrue( pos.getErrorIndex() == 1 );

        pos = new ParsePosition( 0 );
        IBAN.parse( "X0", pos );
        assertTrue( pos.getErrorIndex() == 1 );

        pos = new ParsePosition( 0 );
        IBAN.parse( "0X", pos );
        assertTrue( pos.getErrorIndex() == 0 );

        pos = new ParsePosition( 0 );
        IBAN.parse( "XX", pos );
        assertTrue( pos.getErrorIndex() == 1 );

        // AL2!n3!n4!n1!n16!c
        pos = new ParsePosition( 0 );
        IBAN.parse( "AL4721211009235698741", pos );
        assertTrue( pos.getErrorIndex() == "AL4721211009235698741".length() );

        pos = new ParsePosition( 0 );
        IBAN.parse( "AL472X2110090000000235698741", pos );
        assertTrue( pos.getErrorIndex() == 5 );

        try
        {
            pos = new ParsePosition( 0 );
            IBAN.parse( "AL00212110090000000235698741", pos );
            fail( "Expected 'IbanCheckDigitsException' not thrown." );
        }
        catch ( final IbanCheckDigitsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
            assertEquals( "AL00212110090000000235698741", e.getIban() );
            assertEquals( BigInteger.ZERO, e.getCheckDigits() );
        }

        try
        {
            pos = new ParsePosition( 0 );
            IBAN.parse( "AL10 2121 1009 0000 0002 3569 8741", pos );
            fail( "Expected 'IbanCheckDigitsException' not thrown." );
        }
        catch ( final IbanCheckDigitsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
            assertEquals( "AL10212110090000000235698741", e.getIban() );
            assertEquals( BigInteger.TEN, e.getCheckDigits() );
        }

        for ( int i = validElectronicFormat.length - 1; i >= 0; i-- )
        {
            pos = new ParsePosition( 0 );
            IBAN iban = IBAN.parse( validElectronicFormat[i], pos );
            assertNotNull( iban );
            assertTrue( pos.getErrorIndex() == -1 );
            assertTrue( pos.getIndex() == validElectronicFormat[i].length() );
            assertEquals( validElectronicFormat[i], iban.toString( IbanFormat.ELECTRONIC ) );
        }

        for ( int i = validPrintFormat.length - 1; i >= 0; i-- )
        {
            pos = new ParsePosition( 0 );
            IBAN iban = IBAN.parse( validPrintFormat[i], pos );
            assertNotNull( iban );
            assertTrue( pos.getErrorIndex() == -1 );
            assertTrue( pos.getIndex() == validPrintFormat[i].length() );
            assertEquals( validPrintFormat[i], iban.toString( IbanFormat.PRINT ) );
        }

        for ( int i = invalid.length - 1; i >= 0; i-- )
        {
            pos = new ParsePosition( 0 );

            if ( invalid[i].equals( "AL47 2121 1009 0000 0002 3569 8741 " )
                 || invalid[i].equals( "AL47212110090000000235698741 " ) )
            {
                final IBAN iban = IBAN.parse( invalid[i], pos );
                assertNotNull( iban );
                assertTrue( pos.getErrorIndex() == -1 );
                assertTrue( pos.getIndex() == invalid[i].length() - 1 );
            }
            else
            {
                assertNull( "'" + invalid[i] + "'", IBAN.parse( invalid[i], pos ) );
                assertTrue( "'" + invalid[i] + "'", pos.getErrorIndex() >= 0 );
            }
        }
    }

    @Test public void ParseIban() throws Exception
    {
        final String[] validElectronicFormat = this.getValidValuesElectronicFormat();
        final String[] validPrintFormat = this.getValidValuesPrintFormat();
        final String[] invalid = this.getInvalidValues();

        try
        {
            IBAN.parse( null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        for ( int i = validElectronicFormat.length - 1; i >= 0; i-- )
        {
            final IBAN iban = IBAN.parse( validElectronicFormat[i] );
            assertNotNull( iban );
            assertEquals( validElectronicFormat[i], iban.toString( IbanFormat.ELECTRONIC ) );
        }

        for ( int i = validPrintFormat.length - 1; i >= 0; i-- )
        {
            final IBAN iban = IBAN.parse( validPrintFormat[i] );
            assertNotNull( iban );
            assertEquals( validPrintFormat[i], iban.toString( IbanFormat.PRINT ) );
        }

        for ( int i = invalid.length - 1; i >= 0; i-- )
        {
            try
            {
                IBAN.parse( invalid[i] );
                fail( "Expected 'IbanSyntaxException' not thrown." );
            }
            catch ( final IbanSyntaxException e )
            {
                System.out.println( e.toString() );
                assertNotNull( e.getMessage() );
            }
        }
    }

    @Test public void ValueOf() throws Exception
    {
        final String[] validElectronicFormatValues = this.getValidValuesElectronicFormat();
        final String[] validPrintFormatValues = this.getValidValuesPrintFormat();
        final String[] invalidValues = this.getInvalidValues();

        try
        {
            IBAN.valueOf( null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        for ( int i = validElectronicFormatValues.length - 1; i >= 0; i-- )
        {
            final IBAN iban = IBAN.valueOf( validElectronicFormatValues[i] );
            assertEquals( validElectronicFormatValues[i], iban.toString( IbanFormat.ELECTRONIC ) );
            System.out.println( iban.toString() );
        }
        for ( int i = validPrintFormatValues.length - 1; i >= 0; i-- )
        {
            final IBAN iban = IBAN.valueOf( validPrintFormatValues[i] );
            assertEquals( validPrintFormatValues[i], iban.toString( IbanFormat.PRINT ) );
            System.out.println( iban.toString() );
        }
        for ( int i = invalidValues.length - 1; i >= 0; i-- )
        {
            try
            {
                IBAN.valueOf( invalidValues[i] );
                fail( "Expected 'IllegalArgumentException' not thrown." );
            }
            catch ( final IllegalArgumentException e )
            {
                System.out.println( e.toString() );
                assertNotNull( e.getMessage() );
            }
        }

        assertEquals( IBAN.parse( "AL47212110090000000235698741" ), IBAN.valueOf( "AL47212110090000000235698741" ) );

        try
        {
            IBAN.valueOf( "AL10212110090000000235698741" );
            fail( "Expected 'IllegalArgumentException' not thrown." );
        }
        catch ( final IllegalArgumentException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }
    }

    @Test public void ValueOfBban() throws Exception
    {
        final IBAN iban = IBAN.valueOf( "AL47212110090000000235698741" );

        try
        {
            IBAN.valueOf( "TEST", (String) null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            IBAN.valueOf( null, "TEST" );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            IBAN.valueOf( "TEST", "212110090000000235698741" );
            fail( "Expected 'IllegalArgumentException' not thrown." );
        }
        catch ( final IllegalArgumentException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        assertEquals( iban, IBAN.valueOf( "AL", "212110090000000235698741" ) );

        // 3!n4!n1!n16!c
        try
        {
            IBAN.valueOf( "AL", "21211009235698741" );
            fail( "Expected 'IllegalArgumentException' not thrown." );
        }
        catch ( final IllegalArgumentException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }
        try
        {
            IBAN.parse( "AL", "2X2110090000000235698741" );
            fail( "Expected 'IllegalArgumentException' not thrown." );
        }
        catch ( final IbanSyntaxException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }
    }

    @Test public void PeekIban() throws Exception
    {
        final String[] validElectronicFormatValues = this.getValidValuesElectronicFormat();
        final String[] validPrintFormatValues = this.getValidValuesPrintFormat();
        final String[] invalidValues = this.getInvalidValues();

        try
        {
            IBAN.peekIban( null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        for ( int i = validElectronicFormatValues.length - 1; i >= 0; i-- )
        {
            assertTrue( validElectronicFormatValues[i], IBAN.peekIban( validElectronicFormatValues[i] ) );
        }
        for ( int i = validPrintFormatValues.length - 1; i >= 0; i-- )
        {
            assertTrue( validPrintFormatValues[i], IBAN.peekIban( validPrintFormatValues[i] ) );
        }
        for ( int i = invalidValues.length - 1; i >= 0; i-- )
        {
            assertFalse( invalidValues[i], IBAN.peekIban( invalidValues[i] ) );
        }

        assertTrue( IBAN.peekIban( "D" ) );
        assertTrue( IBAN.peekIban( "DE" ) );
        assertTrue( IBAN.peekIban( "DE9" ) );
        assertTrue( IBAN.peekIban( "DE99" ) );
        assertTrue( IBAN.peekIban( "DE99 " ) );

        assertTrue( IBAN.peekIban( "D" ) );
        assertFalse( IBAN.peekIban( "D E" ) );
        assertFalse( IBAN.peekIban( "DE 9" ) );
        assertFalse( IBAN.peekIban( "DE9 9" ) );
        assertFalse( IBAN.peekIban( "DE99  " ) );

        assertFalse( IBAN.peekIban( "0" ) );

        assertTrue( IBAN.peekIban( "AL47212110090000000235698741" ) );

        try
        {
            IBAN.peekIban( "AL10212110090000000235698741" );
            fail( "Expected 'IbanCheckDigitsException' not thrown." );
        }
        catch ( final IbanCheckDigitsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
            assertEquals( "AL10212110090000000235698741", e.getIban() );
            assertEquals( BigInteger.TEN, e.getCheckDigits() );
        }

        try
        {
            IBAN.peekIban( "AL10 2121 1009 0000 0002 3569 8741" );
            fail( "Expected 'IbanCheckDigitsException' not thrown." );
        }
        catch ( final IbanCheckDigitsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
            assertEquals( "AL10212110090000000235698741", e.getIban() );
            assertEquals( BigInteger.TEN, e.getCheckDigits() );
        }
    }

    @Test public void ToString() throws Exception
    {
        final IBAN iban = IBAN.parse( "AL47212110090000000235698741" );

        try
        {
            iban.toString( null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        assertEquals( "AL47212110090000000235698741", iban.toString( IbanFormat.ELECTRONIC ) );
        assertEquals( "AL47 2121 1009 0000 0002 3569 8741", iban.toString( IbanFormat.PRINT ) );
    }

    @Test public void Append() throws Exception
    {
        final IBAN iban = IBAN.parse( "AL47212110090000000235698741" );

        try
        {
            iban.append( null, new StringBuilder() );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }
        try
        {
            iban.append( IbanFormat.ELECTRONIC, null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        assertEquals( "AL47212110090000000235698741",
                      iban.append( IbanFormat.ELECTRONIC, new StringBuilder() ).toString() );

        assertEquals( "AL47 2121 1009 0000 0002 3569 8741",
                      iban.append( IbanFormat.PRINT, new StringBuilder() ).toString() );

    }

    @Test public void Formattable() throws Exception
    {
        final IBAN iban = IBAN.parse( "AL47212110090000000235698741" );

        try
        {
            iban.formatTo( null, -1, -1, -1 );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        assertEquals( "AL", String.format( "%1$.2s", iban ) );
        assertEquals( "AL", String.format( "%1$#.2s", iban ) );
        assertEquals( "AL4721", String.format( "%1$.6s", iban ) );
        assertEquals( "AL47 2", String.format( "%1$#.6s", iban ) );
        assertEquals( "AL47212110090000000235698741", String.format( "%1$s", iban ) );
        assertEquals( "AL47 2121 1009 0000 0002 3569 8741", String.format( "%1$#s", iban ) );
        assertEquals( "                      AL47212110090000000235698741", String.format( "%1$50s", iban ) );
        assertEquals( "                AL47 2121 1009 0000 0002 3569 8741", String.format( "%1$#50s", iban ) );
        assertEquals( "AL47212110090000000235698741                      ", String.format( "%1$-50s", iban ) );
        assertEquals( "AL47 2121 1009 0000 0002 3569 8741                ", String.format( "%1$-#50s", iban ) );

        try
        {
            String.format( "%1$S", iban );
            fail( "Expected 'IllegalFormatFlagsException' not thrown." );
        }
        catch ( final IllegalFormatFlagsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            String.format( "%1$-50S", iban );
            fail( "Expected 'IllegalFormatFlagsException' not thrown." );
        }
        catch ( final IllegalFormatFlagsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            String.format( "%1$#S", iban );
            fail( "Expected 'IllegalFormatFlagsException' not thrown." );
        }
        catch ( final IllegalFormatFlagsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        try
        {
            String.format( "%1$-#50S", iban );
            fail( "Expected 'IllegalFormatFlagsException' not thrown." );
        }
        catch ( final IllegalFormatFlagsException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }
    }

    @Test public void EqualsAndHashCode() throws Exception
    {
        final String[] electronic = this.getValidValuesElectronicFormat();
        final String[] print = this.getValidValuesPrintFormat();

        for ( int i = electronic.length - 1; i >= 0; i-- )
        {
            final IBAN iban1 = IBAN.parse( electronic[i] );
            final IBAN iban2 = IBAN.parse( electronic[i] );
            assertEquals( iban1, iban2 );
            assertTrue( iban1.hashCode() == iban2.hashCode() );
        }
        for ( int i = print.length - 1; i >= 0; i-- )
        {
            final IBAN iban1 = IBAN.parse( print[i] );
            final IBAN iban2 = IBAN.parse( print[i] );
            assertEquals( iban1, iban2 );
            assertTrue( iban1.hashCode() == iban2.hashCode() );
        }
    }

    @Test public void CompareTo() throws Exception
    {
        final String[] electronic = this.getValidValuesElectronicFormat();
        final String[] print = this.getValidValuesPrintFormat();
        final IBAN iban = IBAN.valueOf( "AL47212110090000000235698741" );

        try
        {
            iban.compareTo( null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        for ( int i = electronic.length - 1; i >= 0; i-- )
        {
            final IBAN iban1 = IBAN.parse( electronic[i] );
            final IBAN iban2 = IBAN.parse( electronic[i] );
            assertTrue( iban1.compareTo( iban2 ) == 0 );
        }
        for ( int i = print.length - 1; i >= 0; i-- )
        {
            final IBAN iban1 = IBAN.parse( print[i] );
            final IBAN iban2 = IBAN.parse( print[i] );
            assertTrue( iban1.compareTo( iban2 ) == 0 );
        }
    }

    @Test public void BankAndBranchIdentifierAndSepaCountry() throws Exception
    {
        IBAN iban = IBAN.valueOf( "AL47212110090000000235698741" );
        assertEquals( "212", iban.getBankIdentifier() );
        assertEquals( "1100", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "AL47 2121 1009 0000 0002 3569 8741" );
        assertEquals( "212", iban.getBankIdentifier() );
        assertEquals( "1100", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        IBAN bban = IBAN.valueOf( "AL", "212110090000000235698741" );
        assertEquals( iban, bban );
        assertEquals( "212", bban.getBankIdentifier() );
        assertEquals( "1100", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "AL", "2121 1009 0000 0002 3569 8741" );
        assertEquals( iban, bban );
        assertEquals( "212", bban.getBankIdentifier() );
        assertEquals( "1100", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "AD1200012030200359100100" );
        assertEquals( "0001", iban.getBankIdentifier() );
        assertEquals( "2030", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "AD12 0001 2030 2003 5910 0100" );
        assertEquals( "0001", iban.getBankIdentifier() );
        assertEquals( "2030", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "AD", "00012030200359100100" );
        assertEquals( iban, bban );
        assertEquals( "0001", bban.getBankIdentifier() );
        assertEquals( "2030", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "AD", "0001 2030 2003 5910 0100" );
        assertEquals( iban, bban );
        assertEquals( "0001", bban.getBankIdentifier() );
        assertEquals( "2030", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "AT611904300234573201" );
        assertEquals( "19043", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "AT61 1904 3002 3457 3201" );
        assertEquals( "19043", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "AT", "1904300234573201" );
        assertEquals( iban, bban );
        assertEquals( "19043", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "AT", "1904 3002 3457 3201" );
        assertEquals( iban, bban );
        assertEquals( "19043", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "AZ21NABZ00000000137010001944" );
        assertEquals( "NABZ", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "AZ21 NABZ 0000 0000 1370 1000 1944" );
        assertEquals( "NABZ", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "AZ", "NABZ00000000137010001944" );
        assertEquals( iban, bban );
        assertEquals( "NABZ", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "AZ", "NABZ 0000 0000 1370 1000 1944" );
        assertEquals( iban, bban );
        assertEquals( "NABZ", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "BH67BMAG00001299123456" );
        assertEquals( "BMAG", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "BH67 BMAG 0000 1299 1234 56" );
        assertEquals( "BMAG", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "BH", "BMAG00001299123456" );
        assertEquals( iban, bban );
        assertEquals( "BMAG", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "BH", "BMAG 0000 1299 1234 56" );
        assertEquals( iban, bban );
        assertEquals( "BMAG", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "BE68539007547034" );
        assertEquals( "539", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "BE68 5390 0754 7034" );
        assertEquals( "539", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "BE", "539007547034" );
        assertEquals( iban, bban );
        assertEquals( "539", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "BE", "5390 0754 7034" );
        assertEquals( iban, bban );
        assertEquals( "539", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "BA391290079401028494" );
        assertEquals( "129", iban.getBankIdentifier() );
        assertEquals( "007", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "BA39 1290 0794 0102 8494" );
        assertEquals( "129", iban.getBankIdentifier() );
        assertEquals( "007", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "BA", "1290079401028494" );
        assertEquals( iban, bban );
        assertEquals( "129", bban.getBankIdentifier() );
        assertEquals( "007", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "BA", "1290 0794 0102 8494" );
        assertEquals( iban, bban );
        assertEquals( "129", bban.getBankIdentifier() );
        assertEquals( "007", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "BR9700360305000010009795493P1" );
        assertEquals( "00360305", iban.getBankIdentifier() );
        assertEquals( "00001", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "BR97 0036 0305 0000 1000 9795 493P 1" );
        assertEquals( "00360305", iban.getBankIdentifier() );
        assertEquals( "00001", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "BR", "00360305000010009795493P1" );
        assertEquals( iban, bban );
        assertEquals( "00360305", bban.getBankIdentifier() );
        assertEquals( "00001", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "BR", "0036 0305 0000 1000 9795 493P 1" );
        assertEquals( iban, bban );
        assertEquals( "00360305", bban.getBankIdentifier() );
        assertEquals( "00001", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "BG80BNBG96611020345678" );
        assertEquals( "BNBG", iban.getBankIdentifier() );
        assertEquals( "9661", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "BG80 BNBG 9661 1020 3456 78" );
        assertEquals( "BNBG", iban.getBankIdentifier() );
        assertEquals( "9661", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "BG", "BNBG96611020345678" );
        assertEquals( iban, bban );
        assertEquals( "BNBG", bban.getBankIdentifier() );
        assertEquals( "9661", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "BG", "BNBG 9661 1020 3456 78" );
        assertEquals( iban, bban );
        assertEquals( "BNBG", bban.getBankIdentifier() );
        assertEquals( "9661", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "CR0515202001026284066" );
        assertEquals( "152", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "CR05 1520 2001 0262 8406 6" );
        assertEquals( "152", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "CR", "15202001026284066" );
        assertEquals( iban, bban );
        assertEquals( "152", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "CR", "1520 2001 0262 8406 6" );
        assertEquals( iban, bban );
        assertEquals( "152", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "HR1210010051863000160" );
        assertEquals( "1001005", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "HR12 1001 0051 8630 0016 0" );
        assertEquals( "1001005", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "HR", "10010051863000160" );
        assertEquals( iban, bban );
        assertEquals( "1001005", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "HR", "1001 0051 8630 0016 0" );
        assertEquals( iban, bban );
        assertEquals( "1001005", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "CY17002001280000001200527600" );
        assertEquals( "002", iban.getBankIdentifier() );
        assertEquals( "00128", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "CY17 0020 0128 0000 0012 0052 7600" );
        assertEquals( "002", iban.getBankIdentifier() );
        assertEquals( "00128", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "CY", "002001280000001200527600" );
        assertEquals( iban, bban );
        assertEquals( "002", bban.getBankIdentifier() );
        assertEquals( "00128", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "CY", "0020 0128 0000 0012 0052 7600" );
        assertEquals( iban, bban );
        assertEquals( "002", bban.getBankIdentifier() );
        assertEquals( "00128", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "CZ6508000000192000145399" );
        assertEquals( "0800", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "CZ65 0800 0000 1920 0014 5399" );
        assertEquals( "0800", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "CZ", "08000000192000145399" );
        assertEquals( iban, bban );
        assertEquals( "0800", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "CZ", "0800 0000 1920 0014 5399" );
        assertEquals( iban, bban );
        assertEquals( "0800", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "DK5000400440116243" );
        assertEquals( "0040", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "DK50 0040 0440 1162 43" );
        assertEquals( "0040", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "DK", "00400440116243" );
        assertEquals( iban, bban );
        assertEquals( "0040", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "DK", "0040 0440 1162 43" );
        assertEquals( iban, bban );
        assertEquals( "0040", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "FO6264600001631634" );
        assertEquals( "6460", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "FO62 6460 0001 6316 34" );
        assertEquals( "6460", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "FO", "64600001631634" );
        assertEquals( iban, bban );
        assertEquals( "6460", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "FO", "6460 0001 6316 34" );
        assertEquals( iban, bban );
        assertEquals( "6460", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "GL8964710001000206" );
        assertEquals( "6471", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "GL89 6471 0001 0002 06" );
        assertEquals( "6471", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "GL", "64710001000206" );
        assertEquals( iban, bban );
        assertEquals( "6471", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GL", "6471 0001 0002 06" );
        assertEquals( iban, bban );
        assertEquals( "6471", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "DO28BAGR00000001212453611324" );
        assertEquals( "BAGR", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "DO28 BAGR 0000 0001 2124 5361 1324" );
        assertEquals( "BAGR", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "DO", "BAGR00000001212453611324" );
        assertEquals( iban, bban );
        assertEquals( "BAGR", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "DO", "BAGR 0000 0001 2124 5361 1324" );
        assertEquals( iban, bban );
        assertEquals( "BAGR", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "EE382200221020145685" );
        assertEquals( "22", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "EE38 2200 2210 2014 5685" );
        assertEquals( "22", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "EE", "2200221020145685" );
        assertEquals( iban, bban );
        assertEquals( "22", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "EE", "2200 2210 2014 5685" );
        assertEquals( iban, bban );
        assertEquals( "22", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "FI2112345600000785" );
        assertEquals( "123", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "FI21 1234 5600 0007 85" );
        assertEquals( "123", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "FI", "12345600000785" );
        assertEquals( iban, bban );
        assertEquals( "123", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "FI", "1234 5600 0007 85" );
        assertEquals( iban, bban );
        assertEquals( "123", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "AX", "1234 5600 0007 85" );
        assertEquals( iban, bban );
        assertEquals( "AX", bban.getCountryCode() );
        assertEquals( "123", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "FR1420041010050500013M02606" );
        assertEquals( "20041", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "FR14 2004 1010 0505 0001 3M02 606" );
        assertEquals( "20041", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "FR", "20041010050500013M02606" );
        assertEquals( iban, bban );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "FR", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "BL", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "BL", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GF", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "GF", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GP", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "GP", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MF", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "MF", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MQ", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "MQ", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "NC", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "NC", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "PF", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "PF", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "PM", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "PM", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "RE", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "RE", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "TF", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "TF", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "WF", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "WF", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "YT", "2004 1010 0505 0001 3M02 606" );
        assertEquals( iban, bban );
        assertEquals( "YT", bban.getCountryCode() );
        assertEquals( "20041", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "GE29NB0000000101904917" );
        assertEquals( "NB", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "GE29 NB00 0000 0101 9049 17" );
        assertEquals( "NB", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "GE", "NB0000000101904917" );
        assertEquals( iban, bban );
        assertEquals( "NB", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GE", "NB00 0000 0101 9049 17" );
        assertEquals( iban, bban );
        assertEquals( "NB", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "DE89370400440532013000" );
        assertEquals( "37040044", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "DE89 3704 0044 0532 0130 00" );
        assertEquals( "37040044", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "DE", "370400440532013000" );
        assertEquals( iban, bban );
        assertEquals( "37040044", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "DE", "3704 0044 0532 0130 00" );
        assertEquals( iban, bban );
        assertEquals( "37040044", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "GI75NWBK000000007099453" );
        assertEquals( "NWBK", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "GI75 NWBK 0000 0000 7099 453" );
        assertEquals( "NWBK", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "GI", "NWBK000000007099453" );
        assertEquals( iban, bban );
        assertEquals( "NWBK", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GI", "NWBK 0000 0000 7099 453" );
        assertEquals( iban, bban );
        assertEquals( "NWBK", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "GR1601101250000000012300695" );
        assertEquals( "011", iban.getBankIdentifier() );
        assertEquals( "0125", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "GR16 0110 1250 0000 0001 2300 695" );
        assertEquals( "011", iban.getBankIdentifier() );
        assertEquals( "0125", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "GR", "01101250000000012300695" );
        assertEquals( iban, bban );
        assertEquals( "011", bban.getBankIdentifier() );
        assertEquals( "0125", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GR", "0110 1250 0000 0001 2300 695" );
        assertEquals( iban, bban );
        assertEquals( "011", bban.getBankIdentifier() );
        assertEquals( "0125", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "GT82TRAJ01020000001210029690" );
        assertEquals( "TRAJ", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "GT82 TRAJ 0102 0000 0012 1002 9690" );
        assertEquals( "TRAJ", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "GT", "TRAJ01020000001210029690" );
        assertEquals( iban, bban );
        assertEquals( "TRAJ", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GT", "TRAJ 0102 0000 0012 1002 9690" );
        assertEquals( iban, bban );
        assertEquals( "TRAJ", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "HU42117730161111101800000000" );
        assertEquals( "117", iban.getBankIdentifier() );
        assertEquals( "7301", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "HU42 1177 3016 1111 1018 0000 0000" );
        assertEquals( "117", iban.getBankIdentifier() );
        assertEquals( "7301", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "HU", "117730161111101800000000" );
        assertEquals( iban, bban );
        assertEquals( "117", bban.getBankIdentifier() );
        assertEquals( "7301", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "HU", "1177 3016 1111 1018 0000 0000" );
        assertEquals( iban, bban );
        assertEquals( "117", bban.getBankIdentifier() );
        assertEquals( "7301", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "IS140159260076545510730339" );
        assertEquals( "0159", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "IS14 0159 2600 7654 5510 7303 39" );
        assertEquals( "0159", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "IS", "0159260076545510730339" );
        assertEquals( iban, bban );
        assertEquals( "0159", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "IS", "0159 2600 7654 5510 7303 39" );
        assertEquals( iban, bban );
        assertEquals( "0159", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "IE29AIBK93115212345678" );
        assertEquals( "AIBK", iban.getBankIdentifier() );
        assertEquals( "931152", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "IE29 AIBK 9311 5212 3456 78" );
        assertEquals( "AIBK", iban.getBankIdentifier() );
        assertEquals( "931152", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "IE", "AIBK93115212345678" );
        assertEquals( iban, bban );
        assertEquals( "AIBK", bban.getBankIdentifier() );
        assertEquals( "931152", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "IE", "AIBK 9311 5212 3456 78" );
        assertEquals( iban, bban );
        assertEquals( "AIBK", bban.getBankIdentifier() );
        assertEquals( "931152", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "IL620108000000099999999" );
        assertEquals( "010", iban.getBankIdentifier() );
        assertEquals( "800", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "IL62 0108 0000 0009 9999 999" );
        assertEquals( "010", iban.getBankIdentifier() );
        assertEquals( "800", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "IL", "0108000000099999999" );
        assertEquals( iban, bban );
        assertEquals( "010", bban.getBankIdentifier() );
        assertEquals( "800", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "IL", "0108 0000 0009 9999 999" );
        assertEquals( iban, bban );
        assertEquals( "010", bban.getBankIdentifier() );
        assertEquals( "800", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "IT60X0542811101000000123456" );
        assertEquals( "05428", iban.getBankIdentifier() );
        assertEquals( "11101", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "IT60 X054 2811 1010 0000 0123 456" );
        assertEquals( "05428", iban.getBankIdentifier() );
        assertEquals( "11101", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "IT", "X0542811101000000123456" );
        assertEquals( iban, bban );
        assertEquals( "05428", bban.getBankIdentifier() );
        assertEquals( "11101", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "IT", "X054 2811 1010 0000 0123 456" );
        assertEquals( iban, bban );
        assertEquals( "05428", bban.getBankIdentifier() );
        assertEquals( "11101", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "KZ86125KZT5004100100" );
        assertEquals( "125", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "KZ86 125K ZT50 0410 0100" );
        assertEquals( "125", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "KZ", "125KZT5004100100" );
        assertEquals( iban, bban );
        assertEquals( "125", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "KZ", "125K ZT50 0410 0100" );
        assertEquals( iban, bban );
        assertEquals( "125", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "KW81CBKU0000000000001234560101" );
        assertEquals( "CBKU", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "KW81 CBKU 0000 0000 0000 1234 5601 01" );
        assertEquals( "CBKU", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "KW", "CBKU0000000000001234560101" );
        assertEquals( iban, bban );
        assertEquals( "CBKU", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "KW", "CBKU 0000 0000 0000 1234 5601 01" );
        assertEquals( iban, bban );
        assertEquals( "CBKU", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "LV80BANK0000435195001" );
        assertEquals( "BANK", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "LV80 BANK 0000 4351 9500 1" );
        assertEquals( "BANK", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "LV", "BANK0000435195001" );
        assertEquals( iban, bban );
        assertEquals( "BANK", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "LV", "BANK 0000 4351 9500 1" );
        assertEquals( iban, bban );
        assertEquals( "BANK", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "LB62099900000001001901229114" );
        assertEquals( "0999", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "LB62 0999 0000 0001 0019 0122 9114" );
        assertEquals( "0999", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "LB", "099900000001001901229114" );
        assertEquals( iban, bban );
        assertEquals( "0999", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "LB", "0999 0000 0001 0019 0122 9114" );
        assertEquals( iban, bban );
        assertEquals( "0999", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "LI21088100002324013AA" );
        assertEquals( "08810", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "LI21 0881 0000 2324 013A A" );
        assertEquals( "08810", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "LI", "088100002324013AA" );
        assertEquals( iban, bban );
        assertEquals( "08810", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "LI", "0881 0000 2324 013A A" );
        assertEquals( iban, bban );
        assertEquals( "08810", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "LT121000011101001000" );
        assertEquals( "10000", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "LT12 1000 0111 0100 1000" );
        assertEquals( "10000", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "LT", "1000011101001000" );
        assertEquals( iban, bban );
        assertEquals( "10000", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "LT", "1000 0111 0100 1000" );
        assertEquals( iban, bban );
        assertEquals( "10000", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "LU280019400644750000" );
        assertEquals( "001", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "LU28 0019 4006 4475 0000" );
        assertEquals( "001", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "LU", "0019400644750000" );
        assertEquals( iban, bban );
        assertEquals( "001", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "LU", "0019 4006 4475 0000" );
        assertEquals( iban, bban );
        assertEquals( "001", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "MK07250120000058984" );
        assertEquals( "250", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "MK07 2501 2000 0058 984" );
        assertEquals( "250", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "MK", "250120000058984" );
        assertEquals( iban, bban );
        assertEquals( "250", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MK", "2501 2000 0058 984" );
        assertEquals( iban, bban );
        assertEquals( "250", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "MT84MALT011000012345MTLCAST001S" );
        assertEquals( "MALT", iban.getBankIdentifier() );
        assertEquals( "01100", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "MT84 MALT 0110 0001 2345 MTLC AST0 01S" );
        assertEquals( "MALT", iban.getBankIdentifier() );
        assertEquals( "01100", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "MT", "MALT011000012345MTLCAST001S" );
        assertEquals( iban, bban );
        assertEquals( "MALT", bban.getBankIdentifier() );
        assertEquals( "01100", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MT", "MALT 0110 0001 2345 MTLC AST0 01S" );
        assertEquals( iban, bban );
        assertEquals( "MALT", bban.getBankIdentifier() );
        assertEquals( "01100", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "MR1300020001010000123456753" );
        assertEquals( "00020", iban.getBankIdentifier() );
        assertEquals( "00101", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "MR13 0002 0001 0100 0012 3456 753" );
        assertEquals( "00020", iban.getBankIdentifier() );
        assertEquals( "00101", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "MR", "00020001010000123456753" );
        assertEquals( iban, bban );
        assertEquals( "00020", bban.getBankIdentifier() );
        assertEquals( "00101", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MR", "0002 0001 0100 0012 3456 753" );
        assertEquals( iban, bban );
        assertEquals( "00020", bban.getBankIdentifier() );
        assertEquals( "00101", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "MU17BOMM0101101030300200000MUR" );
        assertEquals( "BOMM01", iban.getBankIdentifier() );
        assertEquals( "01", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "MU17 BOMM 0101 1010 3030 0200 000M UR" );
        assertEquals( "BOMM01", iban.getBankIdentifier() );
        assertEquals( "01", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "MU", "BOMM0101101030300200000MUR" );
        assertEquals( iban, bban );
        assertEquals( "BOMM01", bban.getBankIdentifier() );
        assertEquals( "01", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MU", "BOMM 0101 1010 3030 0200 000M UR" );
        assertEquals( iban, bban );
        assertEquals( "BOMM01", bban.getBankIdentifier() );
        assertEquals( "01", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "MD24AG000225100013104168" );
        assertEquals( "AG", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "MD24 AG00 0225 1000 1310 4168" );
        assertEquals( "AG", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "MD", "AG000225100013104168" );
        assertEquals( iban, bban );
        assertEquals( "AG", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MD", "AG00 0225 1000 1310 4168" );
        assertEquals( iban, bban );
        assertEquals( "AG", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "MC5811222000010123456789030" );
        assertEquals( "11222", iban.getBankIdentifier() );
        assertEquals( "00001", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "MC58 1122 2000 0101 2345 6789 030" );
        assertEquals( "11222", iban.getBankIdentifier() );
        assertEquals( "00001", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "MC", "11222000010123456789030" );
        assertEquals( iban, bban );
        assertEquals( "11222", bban.getBankIdentifier() );
        assertEquals( "00001", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "MC", "1122 2000 0101 2345 6789 030" );
        assertEquals( iban, bban );
        assertEquals( "11222", bban.getBankIdentifier() );
        assertEquals( "00001", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "ME25505000012345678951" );
        assertEquals( "505", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "ME25 5050 0001 2345 6789 51" );
        assertEquals( "505", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "ME", "505000012345678951" );
        assertEquals( iban, bban );
        assertEquals( "505", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "ME", "5050 0001 2345 6789 51" );
        assertEquals( iban, bban );
        assertEquals( "505", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "NL91ABNA0417164300" );
        assertEquals( "ABNA", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "NL91 ABNA 0417 1643 00" );
        assertEquals( "ABNA", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "NL", "ABNA0417164300" );
        assertEquals( iban, bban );
        assertEquals( "ABNA", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "NL", "ABNA 0417 1643 00" );
        assertEquals( iban, bban );
        assertEquals( "ABNA", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "NO9386011117947" );
        assertEquals( "8601", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "NO93 8601 1117 947" );
        assertEquals( "8601", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "NO", "86011117947" );
        assertEquals( iban, bban );
        assertEquals( "8601", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "NO", "8601 1117 947" );
        assertEquals( iban, bban );
        assertEquals( "8601", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "PK36SCBL0000001123456702" );
        assertEquals( "SCBL", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "PK36 SCBL 0000 0011 2345 6702" );
        assertEquals( "SCBL", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "PK", "SCBL0000001123456702" );
        assertEquals( iban, bban );
        assertEquals( "SCBL", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "PK", "SCBL 0000 0011 2345 6702" );
        assertEquals( iban, bban );
        assertEquals( "SCBL", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "PS92PALS000000000400123456702" );
        assertEquals( "PALS", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "PS92 PALS 0000 0000 0400 1234 5670 2" );
        assertEquals( "PALS", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "PS", "PALS000000000400123456702" );
        assertEquals( iban, bban );
        assertEquals( "PALS", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "PS", "PALS 0000 0000 0400 1234 5670 2" );
        assertEquals( iban, bban );
        assertEquals( "PALS", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "PL61109010140000071219812874" );
        assertEquals( "10901014", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "PL61 1090 1014 0000 0712 1981 2874" );
        assertEquals( "10901014", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "PL", "109010140000071219812874" );
        assertEquals( iban, bban );
        assertEquals( "10901014", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "PL", "1090 1014 0000 0712 1981 2874" );
        assertEquals( iban, bban );
        assertEquals( "10901014", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "PT50000201231234567890154" );
        assertEquals( "0002", iban.getBankIdentifier() );
        assertEquals( "0123", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "PT50 0002 0123 1234 5678 9015 4" );
        assertEquals( "0002", iban.getBankIdentifier() );
        assertEquals( "0123", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "PT", "000201231234567890154" );
        assertEquals( iban, bban );
        assertEquals( "0002", bban.getBankIdentifier() );
        assertEquals( "0123", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "PT", "0002 0123 1234 5678 9015 4" );
        assertEquals( iban, bban );
        assertEquals( "0002", bban.getBankIdentifier() );
        assertEquals( "0123", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "QA58DOHB00001234567890ABCDEFG" );
        assertEquals( "DOHB", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "QA58 DOHB 0000 1234 5678 90AB CDEF G" );
        assertEquals( "DOHB", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "QA", "DOHB00001234567890ABCDEFG" );
        assertEquals( iban, bban );
        assertEquals( "DOHB", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "QA", "DOHB 0000 1234 5678 90AB CDEF G" );
        assertEquals( iban, bban );
        assertEquals( "DOHB", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "RO49AAAA1B31007593840000" );
        assertEquals( "AAAA", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "RO49 AAAA 1B31 0075 9384 0000" );
        assertEquals( "AAAA", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "RO", "AAAA1B31007593840000" );
        assertEquals( iban, bban );
        assertEquals( "AAAA", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "RO", "AAAA 1B31 0075 9384 0000" );
        assertEquals( iban, bban );
        assertEquals( "AAAA", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "SM86U0322509800000000270100" );
        assertEquals( "03225", iban.getBankIdentifier() );
        assertEquals( "09800", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "SM86 U032 2509 8000 0000 0270 100" );
        assertEquals( "03225", iban.getBankIdentifier() );
        assertEquals( "09800", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "SM", "U0322509800000000270100" );
        assertEquals( iban, bban );
        assertEquals( "03225", bban.getBankIdentifier() );
        assertEquals( "09800", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "SM", "U032 2509 8000 0000 0270 100" );
        assertEquals( iban, bban );
        assertEquals( "03225", bban.getBankIdentifier() );
        assertEquals( "09800", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "SA0380000000608010167519" );
        assertEquals( "80", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "SA03 8000 0000 6080 1016 7519" );
        assertEquals( "80", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "SA", "80000000608010167519" );
        assertEquals( iban, bban );
        assertEquals( "80", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "SA", "8000 0000 6080 1016 7519" );
        assertEquals( iban, bban );
        assertEquals( "80", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "RS35260005601001611379" );
        assertEquals( "260", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "RS35 2600 0560 1001 6113 79" );
        assertEquals( "260", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "RS", "260005601001611379" );
        assertEquals( iban, bban );
        assertEquals( "260", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "RS", "2600 0560 1001 6113 79" );
        assertEquals( iban, bban );
        assertEquals( "260", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "SK3112000000198742637541" );
        assertEquals( "1200", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "SK31 1200 0000 1987 4263 7541" );
        assertEquals( "1200", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "SK", "12000000198742637541" );
        assertEquals( iban, bban );
        assertEquals( "1200", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "SK", "1200 0000 1987 4263 7541" );
        assertEquals( iban, bban );
        assertEquals( "1200", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "SI56263300012039086" );
        assertEquals( "26", iban.getBankIdentifier() );
        assertEquals( "330", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "SI56 2633 0001 2039 086" );
        assertEquals( "26", iban.getBankIdentifier() );
        assertEquals( "330", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "SI", "263300012039086" );
        assertEquals( iban, bban );
        assertEquals( "26", bban.getBankIdentifier() );
        assertEquals( "330", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "SI", "2633 0001 2039 086" );
        assertEquals( iban, bban );
        assertEquals( "26", bban.getBankIdentifier() );
        assertEquals( "330", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "ES9121000418450200051332" );
        assertEquals( "2100", iban.getBankIdentifier() );
        assertEquals( "0418", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "ES91 2100 0418 4502 0005 1332" );
        assertEquals( "2100", iban.getBankIdentifier() );
        assertEquals( "0418", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "ES", "21000418450200051332" );
        assertEquals( iban, bban );
        assertEquals( "2100", bban.getBankIdentifier() );
        assertEquals( "0418", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "ES", "2100 0418 4502 0005 1332" );
        assertEquals( iban, bban );
        assertEquals( "2100", bban.getBankIdentifier() );
        assertEquals( "0418", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "SE4550000000058398257466" );
        assertEquals( "500", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "SE45 5000 0000 0583 9825 7466" );
        assertEquals( "500", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "SE", "50000000058398257466" );
        assertEquals( iban, bban );
        assertEquals( "500", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "SE", "5000 0000 0583 9825 7466" );
        assertEquals( iban, bban );
        assertEquals( "500", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "CH9300762011623852957" );
        assertEquals( "00762", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "CH93 0076 2011 6238 5295 7" );
        assertEquals( "00762", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "CH", "00762011623852957" );
        assertEquals( iban, bban );
        assertEquals( "00762", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "CH", "0076 2011 6238 5295 7" );
        assertEquals( iban, bban );
        assertEquals( "00762", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        iban = IBAN.valueOf( "TN5910006035183598478831" );
        assertEquals( "10", iban.getBankIdentifier() );
        assertEquals( "006", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "TN59 1000 6035 1835 9847 8831" );
        assertEquals( "10", iban.getBankIdentifier() );
        assertEquals( "006", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "TN", "10006035183598478831" );
        assertEquals( iban, bban );
        assertEquals( "10", bban.getBankIdentifier() );
        assertEquals( "006", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "TN", "1000 6035 1835 9847 8831" );
        assertEquals( iban, bban );
        assertEquals( "10", bban.getBankIdentifier() );
        assertEquals( "006", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "TR330006100519786457841326" );
        assertEquals( "00061", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "TR33 0006 1005 1978 6457 8413 26" );
        assertEquals( "00061", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "TR", "0006100519786457841326" );
        assertEquals( iban, bban );
        assertEquals( "00061", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "TR", "0006 1005 1978 6457 8413 26" );
        assertEquals( iban, bban );
        assertEquals( "00061", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "AE070331234567890123456" );
        assertEquals( "033", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "AE07 0331 2345 6789 0123 456" );
        assertEquals( "033", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "AE", "0331234567890123456" );
        assertEquals( iban, bban );
        assertEquals( "033", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "AE", "0331 2345 6789 0123 456" );
        assertEquals( iban, bban );
        assertEquals( "033", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "GB29NWBK60161331926819" );
        assertEquals( "NWBK", iban.getBankIdentifier() );
        assertEquals( "601613", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        iban = IBAN.valueOf( "GB29 NWBK 6016 1331 9268 19" );
        assertEquals( "NWBK", iban.getBankIdentifier() );
        assertEquals( "601613", iban.getBranchIdentifier() );
        assertTrue( iban.isSepaCountry() );

        bban = IBAN.valueOf( "GB", "NWBK60161331926819" );
        assertEquals( iban, bban );
        assertEquals( "NWBK", bban.getBankIdentifier() );
        assertEquals( "601613", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GB", "NWBK 6016 1331 9268 19" );
        assertEquals( iban, bban );
        assertEquals( "NWBK", bban.getBankIdentifier() );
        assertEquals( "601613", bban.getBranchIdentifier() );
        assertTrue( bban.isSepaCountry() );

        bban = IBAN.valueOf( "JE", "NWBK 6016 1331 9268 19" );
        assertEquals( iban, bban );
        assertEquals( "JE", bban.getCountryCode() );
        assertEquals( "NWBK", bban.getBankIdentifier() );
        assertEquals( "601613", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "GG", "NWBK 6016 1331 9268 19" );
        assertEquals( iban, bban );
        assertEquals( "GG", bban.getCountryCode() );
        assertEquals( "NWBK", bban.getBankIdentifier() );
        assertEquals( "601613", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "IM", "NWBK 6016 1331 9268 19" );
        assertEquals( iban, bban );
        assertEquals( "IM", bban.getCountryCode() );
        assertEquals( "NWBK", bban.getBankIdentifier() );
        assertEquals( "601613", bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        iban = IBAN.valueOf( "VG96VPVG0000012345678901" );
        assertEquals( "VPVG", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        iban = IBAN.valueOf( "VG96 VPVG 0000 0123 4567 8901" );
        assertEquals( "VPVG", iban.getBankIdentifier() );
        assertNull( iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );

        bban = IBAN.valueOf( "VG", "VPVG0000012345678901" );
        assertEquals( iban, bban );
        assertEquals( "VPVG", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );

        bban = IBAN.valueOf( "VG", "VPVG 0000 0123 4567 8901" );
        assertEquals( iban, bban );
        assertEquals( "VPVG", bban.getBankIdentifier() );
        assertNull( bban.getBranchIdentifier() );
        assertFalse( bban.isSepaCountry() );
    }

    @Test public void Serializable() throws Exception
    {
        final ObjectOutputStream out = new ObjectOutputStream( new ByteArrayOutputStream() );
        out.writeObject( IBAN.valueOf( "AL47212110090000000235698741" ) );
        out.close();

        final ObjectInputStream in = new ObjectInputStream( this.getClass().getResourceAsStream( "IBAN.ser" ) );
        final IBAN iban = (IBAN) in.readObject();
        in.close();

        System.out.println( iban.toString() );
        assertEquals( IBAN.valueOf( "AL47212110090000000235698741" ), iban );
        assertEquals( "AL47212110090000000235698741", iban.toString( IbanFormat.ELECTRONIC ) );
        assertEquals( "AL47 2121 1009 0000 0002 3569 8741", iban.toString( IbanFormat.PRINT ) );
        assertEquals( "212", iban.getBankIdentifier() );
        assertEquals( "1100", iban.getBranchIdentifier() );
        assertFalse( iban.isSepaCountry() );
    }
//
//    public static void main( final String... arguments ) throws Exception
//    {
//        final ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( "IBAN.ser" ) );
//        out.writeObject( IBAN.valueOf( "AL47212110090000000235698741" ) );
//        out.close();
//    }
//
    // SECTION-END
    // SECTION-START[Constructors]
    // <editor-fold defaultstate="collapsed" desc=" Generated Constructors ">
    /** Creates a new {@code IbanTest} instance. */
    @javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.5", comments = "See http://www.jomc.org/jomc/1.5/jomc-tools-1.5" )
    public IbanTest()
    {
        // SECTION-START[Default Constructor]
        super();
        // SECTION-END
    }
    // </editor-fold>
    // SECTION-END
    // SECTION-START[Dependencies]
    // SECTION-END
    // SECTION-START[Properties]
    // SECTION-END
    // SECTION-START[Messages]
    // SECTION-END

}
