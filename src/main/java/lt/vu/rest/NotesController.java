package lt.vu.rest;
        import lt.vu.entities.Notes;
        import lt.vu.usecases.cdi.dao.NoteDAO;

        import javax.enterprise.context.ApplicationScoped;
        import javax.inject.Inject;
        import javax.transaction.Transactional;
        import javax.ws.rs.*;
        import javax.ws.rs.core.MediaType;
        import java.util.Set;

@ApplicationScoped
@Path("/notes")
public class NotesController {
    @Inject
    private NoteDAO noteDAO;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Notes> getAll() {
        return noteDAO.getAllSaves();
    }

    @Path("/")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Notes> create(String msg) {
        Notes note = new Notes();
        note.setNoteDescription(msg);
        noteDAO.create(note);
        return noteDAO.getAllSaves();
    }

    @POST
    @Path("/post")
    public Notes update(RequestObject obj) {
        Notes note = noteDAO.findOne(obj.id);
        note.setNoteDescription(obj.message);
        return noteDAO.update(note);
    }
}