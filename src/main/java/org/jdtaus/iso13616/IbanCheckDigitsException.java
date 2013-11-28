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

import java.util.Locale;

// SECTION-START[Documentation]
// <editor-fold defaultstate="collapsed" desc=" Generated Documentation ">
/**
 * Gets thrown whenever validation of the check digits of an international bank account number fails.
 *
 * <dl>
 *   <dt><b>Identifier:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN Check Digits Exception</dd>
 *   <dt><b>Name:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ IBAN Check Digits Exception</dd>
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
@javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.5", comments = "See http://www.jomc.org/jomc/1.5/jomc-tools-1.5" )
// </editor-fold>
// SECTION-END
public class IbanCheckDigitsException extends Exception
{
    // SECTION-START[IbanCheckDigitsException]

    /** Serial version UID for backwards compatibility with 2007.45.x classes. */
    private static final long serialVersionUID = 2758511596781778791L;

    /**
     * The IBAN failing check digits validation.
     * @serial
     */
    private String iban;

    /**
     * The invalid check digits.
     * @serial
     */
    private Number checkDigits;

    /**
     * Creates a new {@code IbanCheckDigitsException} instance taking the IBAN failing check digits validation and the
     * invalid check digits.
     *
     * @param iban The IBAN failing check digits validation.
     * @param checkDigits The invalid check digits.
     */
    public IbanCheckDigitsException( final String iban, final Number checkDigits )
    {
        super();
        this.iban = iban;
        this.checkDigits = checkDigits;
    }

    /**
     * Gets a message describing the exception.
     *
     * @return A message describing the exception.
     */
    @Override
    public String getMessage()
    {
        return getIbanCheckDigitsExceptionMessage( Locale.getDefault(), this.getIban(), this.getCheckDigits() );
    }

    /**
     * Gets a localized message describing the exception for a given locale.
     *
     * @param locale The locale of the localized message to get.
     *
     * @return A localized message describing the exception.
     *
     * @throws NullPointerException if {@code locale} is {@code null}.
     */
    public String getLocalizedMessage( final Locale locale )
    {
        if ( locale == null )
        {
            throw new NullPointerException( "locale" );
        }

        return getIbanCheckDigitsExceptionMessage( locale, this.getIban(), this.getCheckDigits() );
    }

    /**
     * Gets the IBAN failing check digits validation.
     *
     * @return The IBAN failing check digits validation.
     */
    public String getIban()
    {
        return this.iban;
    }

    /**
     * Gets the invalid check digits.
     *
     * @return The invalid check digits.
     */
    public Number getCheckDigits()
    {
        return this.checkDigits;
    }

    // SECTION-END
    // SECTION-START[Dependencies]
    // SECTION-END
    // SECTION-START[Properties]
    // SECTION-END
    // SECTION-START[Messages]
    // <editor-fold defaultstate="collapsed" desc=" Generated Messages ">
    /**
     * Gets the text of the {@code <IBAN Check Digits Exception Message>} message.
     * <p><dl>
     *   <dt><b>Languages:</b></dt>
     *     <dd>English (default)</dd>
     *     <dd>Deutsch</dd>
     *   <dt><b>Final:</b></dt><dd>No</dd>
     * </dl></p>
     * @param locale The locale of the message to return.
     * @param iban Format argument.
     * @param illegalCheckDigits Format argument.
     * @return The text of the {@code <IBAN Check Digits Exception Message>} message for {@code locale}.
     */
    @SuppressWarnings("unused")
    @javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.5", comments = "See http://www.jomc.org/jomc/1.5/jomc-tools-1.5" )
    private static String getIbanCheckDigitsExceptionMessage( final java.util.Locale locale, final java.lang.String iban, final java.lang.Number illegalCheckDigits )
    {
        java.io.BufferedReader reader = null;

        try
        {
            final String message = java.text.MessageFormat.format( java.util.ResourceBundle.getBundle( "org.jdtaus.iso13616.IbanCheckDigitsException", locale ).getString( "IBAN Check Digits Exception Message" ), iban, illegalCheckDigits, (Object) null );
            final java.lang.StringBuilder builder = new java.lang.StringBuilder( message.length() );
            reader = new java.io.BufferedReader( new java.io.StringReader( message ) );
            final String lineSeparator = System.getProperty( "line.separator", "\n" );

            String line;
            while ( ( line = reader.readLine() ) != null )
            {
                builder.append( lineSeparator ).append( line );
            }

            reader.close();
            reader = null;
            return builder.length() > 0 ? builder.substring( lineSeparator.length() ) : "";
        }
        catch( final java.io.IOException e )
        {
            throw new java.lang.AssertionError( e );
        }
        finally
        {
            try
            {
                if( reader != null )
                {
                    reader.close();
                }
            }
            catch( final java.io.IOException e )
            {
                throw new java.lang.AssertionError( e );
            }
        }
    }
    // </editor-fold>
    // SECTION-END
}
