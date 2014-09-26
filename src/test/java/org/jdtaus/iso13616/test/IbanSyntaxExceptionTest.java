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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import org.jdtaus.iso13616.IbanSyntaxException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

// SECTION-START[Documentation]
// <editor-fold defaultstate="collapsed" desc=" Generated Documentation ">
/**
 * Testcases for class {@code org.jdtaus.iban.IbanSyntaxException}.
 *
 * <dl>
 *   <dt><b>Identifier:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ Tests ⁑ IBAN Syntax Exception Test</dd>
 *   <dt><b>Name:</b></dt><dd>jDTAUS ⁑ ISO-13616 ⁑ Tests ⁑ IBAN Syntax Exception Test</dd>
 *   <dt><b>Abstract:</b></dt><dd>No</dd>
 *   <dt><b>Final:</b></dt><dd>Yes</dd>
 *   <dt><b>Stateless:</b></dt><dd>Yes</dd>
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
public class IbanSyntaxExceptionTest
{
    // SECTION-START[IbanSyntaxExceptionTest]

    @Test public void LocalizedMessage() throws Exception
    {
        final IbanSyntaxException ibanSyntaxException = new IbanSyntaxException( "TEST", Integer.MAX_VALUE );

        try
        {
            ibanSyntaxException.getLocalizedMessage( null );
            fail( "Expected 'NullPointerException' not thrown." );
        }
        catch ( final NullPointerException e )
        {
            System.out.println( e.toString() );
            assertNotNull( e.getMessage() );
        }

        assertNotNull( ibanSyntaxException.getLocalizedMessage( Locale.GERMAN ) );
        assertNotNull( ibanSyntaxException.getLocalizedMessage( Locale.ENGLISH ) );
    }

    @Test public void Serializable() throws Exception
    {
        final ObjectOutputStream out = new ObjectOutputStream( new ByteArrayOutputStream() );
        out.writeObject( new IbanSyntaxException( "TEST", Integer.MAX_VALUE ) );
        out.close();

        final ObjectInputStream in =
            new ObjectInputStream( this.getClass().getResourceAsStream( "IbanSyntaxException.ser" ) );

        final IbanSyntaxException e = (IbanSyntaxException) in.readObject();
        in.close();

        System.out.println( e.toString() );
        assertEquals( "TEST", e.getMalformedText() );
        assertEquals( Integer.MAX_VALUE, e.getErrorIndex() );
    }
//
//    public static void main( final String... arguments ) throws Exception
//    {
//        final ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( "IbanSyntaxException.ser" ) );
//        out.writeObject( new IbanSyntaxException( "TEST", Integer.MAX_VALUE ) );
//        out.close();
//    }
//
    // SECTION-END
    // SECTION-START[Constructors]
    // <editor-fold defaultstate="collapsed" desc=" Generated Constructors ">
    /** Creates a new {@code IbanSyntaxExceptionTest} instance. */
    @javax.annotation.Generated( value = "org.jomc.tools.SourceFileProcessor 1.7", comments = "See http://www.jomc.org/jomc/1.7/jomc-tools-1.7" )
    public IbanSyntaxExceptionTest()
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
